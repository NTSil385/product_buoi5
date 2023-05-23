package product.com.example.product.controller;



import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import product.com.example.product.model.product;
import product.com.example.product.service.productservice;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class productcontroller {
    @Autowired
    private productservice productservice;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listproduct", productservice.getAll());
        return "products/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("product", new product());
        return "products/create";
    }

    @PostMapping("/create")
    public String create(@Valid product items,BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("product", items);
            return "products/create";

        }
       /* if(imageProduct != null && imageProduct.getSize() > 0){
            try{
                File saveFile = new ClassPathResource("static/images").getFile();
                String newImageFile = UUID.randomUUID() + ".png";
                Path path =  Paths.get(saveFile.getAbsolutePath() + File.separator + newImageFile);
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                items.setImage(newImageFile);

            }catch (Exception e){
                e.printStackTrace();
            }
        }*/
        productservice.add(items);
        return "redirect:/products";
    }
}
