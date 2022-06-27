package com.smartcontactmanager.controller;

import com.smartcontactmanager.helper.Message;
import com.smartcontactmanager.models.Contact;
import com.smartcontactmanager.models.User;
import com.smartcontactmanager.service.ContactService;
import com.smartcontactmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ContactService contactService;

    //add common data
    @ModelAttribute
    public void addCommonData(Model model, Principal principal) {
        String email = principal.getName();
        System.out.println("USERNAME : " + email);

        // get the user from database by username
        User user = userService.findUserByUsername(email);

        model.addAttribute("user", user);
        System.out.println(user);
    }

    //home handler
    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("title", "User Dashboard");
        return "normal/user_dashboard";
    }

    //open add form handler
    @RequestMapping("/add_contact")
    public String openAddContactForm(Model model) {
        model.addAttribute("title", "Add Contact");
        model.addAttribute("contact", new Contact());
        return "normal/add_contact_form";
    }

    @RequestMapping(value = "/process-contact", method = RequestMethod.POST)
    public String processContact(@ModelAttribute Contact contact, @RequestParam("profileImage") MultipartFile file, Principal principal, HttpSession session) {
        System.out.println(contact);
        System.out.println(file.getOriginalFilename());

        try {

            String username = principal.getName();
            User user = this.userService.findUserByUsername(username);

            //processing and uploading file
            if (file.isEmpty()) {
                // if the file is empty then try our message
                contact.setImage("contact.png");
                //throw  new Exception("Image Upload Neccessory.....");
            } else {

                // file the file to folder and update the name to contact
                contact.setImage(file.getOriginalFilename());

                File saveFile = new ClassPathResource("static/image").getFile();

                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                System.out.println("Image is Uploaded.....");
            }

            contact.setUser(user);

            user.getContacts().add(contact);

            this.userService.saveUser(user);

            System.out.println("Added to Database");

            //message success
            session.setAttribute("message", new Message("Your Contact is added !!! Add more...", "success"));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());

            //message error
            session.setAttribute("message", new Message("Something Went Wrong Try Again....." + e.getMessage(), "danger"));

        }

        return "normal/add_contact_form";
    }

    //show contact handler
    // per page = 5[n]
    // current page = 0 [page]
    @RequestMapping("/show_contacts/{page}")
    private String showConatcts(@PathVariable("page") int page, Model model, Principal principal) {
        model.addAttribute("title", "Show Contact Page");

        String username = principal.getName();
        User user = this.userService.findUserByUsername(username);

        // currentPage-page
        // conatct Per page
        Pageable pageable = PageRequest.of(page, 8);

        Page<Contact> contacts = this.contactService.getAllContacts(user.getId(), pageable);

        model.addAttribute("contacts", contacts);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", contacts.getTotalPages());

        return "normal/show_contact";
    }


    //showing particular contact details
    @RequestMapping(value = "/contact/{cid}")
    public String showContactDetail(@PathVariable("cid") int cid, Model model, Principal principal) {
        System.out.println("Cid : " + cid);

        Contact contact = this.contactService.getContactById(cid);

        String username = principal.getName();
        User user = this.userService.findUserByUsername(username);

        if (user.getId() == contact.getUser().getId()) {
            model.addAttribute("contact", contact);
        }

        return "normal/contact_detail";
    }


    // delete contact handler
    @RequestMapping("/delete/{cid}")
    public String deleteContact(@PathVariable("cid") int cid, Model model, Principal principal, HttpSession session) {
        Contact contact = this.contactService.getContactById(cid);

        String username = principal.getName();
        User user = this.userService.findUserByUsername(username);

        //check... assignment
        if (user.getId() == contact.getUser().getId()) {

            user.getContacts().remove(contact);
            this.userService.saveUser(user);
            session.setAttribute("message", new Message("Contact Deleted Successfully", "alert-success"));
        }

        return "redirect:/user/show_contacts/0";
    }

    //open update from handler
    @RequestMapping(value = "/update-contact/{cid}", method = RequestMethod.POST)
    private String updateForm(@PathVariable("cid") int cid, Model model) {
        model.addAttribute("title", "Upadate-Contact");
        Contact contact = this.contactService.getContactById(cid);
        model.addAttribute("contact", contact);
        return "normal/update_form";
    }


    //update contact handler
    @RequestMapping(value = "/process-update", method = RequestMethod.POST)
    private String updateHandler(@ModelAttribute Contact contact, @RequestParam("profileImage") MultipartFile file,
                                 Model model, HttpSession session, Principal principal) {
        try {
            System.out.println(file.getOriginalFilename());
            System.out.println(contact.getCname() + " " + contact.getEmail());

            // old contact details
            Contact oldContact = this.contactService.getContactById(contact.getCid());

            //image
            if (!file.isEmpty()) {
                //file work
                //rewrite
                // delete old

                File deleteFile = new ClassPathResource("static/image").getFile();
                File file1 = new File(deleteFile, oldContact.getImage());
                file1.delete();
//
//               File deleteFile = new ClassPathResource("static/image").getFile();
//               Path deletePath = Paths.get(deleteFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
//               Files.delete(deletePath);


                //update new photo
                File saveFile = new ClassPathResource("static/image").getFile();

                Path savePath = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

                Files.copy(file.getInputStream(), savePath, StandardCopyOption.REPLACE_EXISTING);

                contact.setImage(file.getOriginalFilename());

            } else {
                contact.setImage(oldContact.getImage());
            }

            String username = principal.getName();
            User user = this.userService.findUserByUsername(username);
            contact.setUser(user);

            this.contactService.saveContact(contact);
            session.setAttribute("message", new Message("Your Conatct is Updated....", "alert-success"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/user/contact/" + contact.getCid();
    }

    // your profile handler
    @RequestMapping("/profile")
    private String yourProfile(Model model){
        model.addAttribute("title","Profile Page");
        return "normal/profile";
    }


//    @RequestMapping(value = "/process-contact", method = RequestMethod.POST)
//    public String processContact(@RequestParam("image") MultipartFile multipartFile, @RequestParam String cname, @RequestParam String email,
//                                 @RequestParam String secondName, @RequestParam String phone, @RequestParam String work, @RequestParam String description, Principal principal) {
//
//
//        try {
//            String absolutePath = new ClassPathResource("/static/image/").getFile().getPath();
//
//            //Writing the Image
//            byte[] bytes = multipartFile.getBytes();
//            FileOutputStream fileOutputStream = new FileOutputStream(absolutePath + File.separator + multipartFile.getOriginalFilename());
//            fileOutputStream.write(bytes);
//            fileOutputStream.close();
//
//            //private String URL="http://localhost:8081/imagesHub/
//            Contact contact = new Contact(cname, secondName, phone, work, email, description);
//            contact.setImage(absolutePath + "/" + multipartFile.getOriginalFilename());
//
//            System.out.println(absolutePath + "/" + multipartFile.getOriginalFilename());
//
//            String username = principal.getName();
//            User user = this.userService.findUserByUsername(username);
//
//            contact.setUser(user);
//
//            user.getContacts().add(contact);
//
//
//            this.userService.saveUser(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//        return "normal/add_contact_form";
//    }

}
