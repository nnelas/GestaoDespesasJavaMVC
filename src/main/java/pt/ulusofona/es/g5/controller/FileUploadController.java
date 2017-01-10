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
import pt.ulusofona.es.g5.data.Despesa;
import pt.ulusofona.es.g5.form.UploadForm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.io.*;

@Controller
@Transactional
public class FileUploadController {

    @PersistenceContext
    private EntityManager em;

    public static final String UPLOAD_FOLDER = "upload";
    String cvsSplitBy = ",";
    String line = "";

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

                BufferedReader inFile = new BufferedReader(new FileReader(fileName));

                while ((line = inFile.readLine()) != null) {

                    // use comma as separator
                    String[] fileUpload = line.split(cvsSplitBy);

                    String uploadCategoria = "Indefinida";
                    String uploadData = fileUpload[0];
                    String uploadDescricao = fileUpload[1];
                    float uploadValor = Float.parseFloat(fileUpload[2]);
                    String uploadLocalizacao = "";

                    Despesa despesa;
                    despesa = new Despesa();

                    despesa.setCategoria(uploadCategoria);
                    despesa.setData(uploadData);
                    despesa.setDescricao(uploadDescricao);
                    despesa.setValor(uploadValor);
                    despesa.setLocalizacao(uploadLocalizacao);
                    em.persist(despesa);

                }

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
