package pt.ulusofona.es.g5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pt.ulusofona.es.g5.form.UploadForm;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class FileUploadController {

    public static final String UPLOAD_FOLDER = "upload";

    // para ter a certeza que existe a pasta upload
    static {
        new File(UPLOAD_FOLDER).mkdirs();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String getUploadForm(ModelMap model) {
        model.put("uploadForm", new UploadForm());
        return "uploadForm";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(@Valid @ModelAttribute("uploadForm") UploadForm uploadForm,
                                   BindingResult bindingResult,
                                   @RequestParam("file") MultipartFile file,
                                   ModelMap model) {

        if (bindingResult.hasErrors()) {
            return "uploadForm";
        }

        if (!file.isEmpty()) {
            try {
                String fileName = UPLOAD_FOLDER + "/" + System.currentTimeMillis() + "-" + file.getOriginalFilename();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileName));
                stream.write(file.getBytes());
                stream.close();

                model.put("message", "Sucesso. O ficheiro " + file.getOriginalFilename() + " foi guardado com sucesso!");
                return "result";

            } catch (Exception e) {
                model.put("message", "Falha no upload => " + e.getMessage());
                return "result";
            }
        } else {
            model.put("message", "Ficheiro vazio");
            return "result";
        }

    }
}
