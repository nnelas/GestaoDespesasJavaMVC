package pt.ulusofona.es.g5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang.StringUtils;
import pt.ulusofona.es.g5.data.Despesa;
import pt.ulusofona.es.g5.form.DespesaForm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@Transactional
public class FormController {

    @PersistenceContext
    private EntityManager em;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getList(ModelMap model) {

        List<Despesa> despesas = em.createQuery("select d from Despesa d order by d.data DESC", Despesa.class).getResultList();
        model.put("despesas", despesas);
        return "list";
    }


    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getForm(ModelMap model) {
        model.put("despesaForm", new DespesaForm());
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@Valid @ModelAttribute("despesaForm") DespesaForm despesaForm,
                             BindingResult bindingResult,
                             ModelMap model) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        Despesa despesa;
        if(despesaForm.getId() != null) {
            despesa = em.find(Despesa.class, despesaForm.getId());
        } else {
            despesa = new Despesa();
        }

        String despesaCategoria = StringUtils.strip(despesaForm.getCategoria(), ",");
        despesa.setCategoria(despesaCategoria);
        despesa.setData(despesaForm.getData());
        despesa.setDescricao(despesaForm.getDescricao());
        despesa.setValor(despesaForm.getValor());
        despesa.setLocalizacao(despesaForm.getLocalizacao());
        em.persist(despesa);

        model.addAttribute("message", "Sucesso! A despesa de " + despesa.getCategoria() + " no dia " + despesa.getData() +
                " foi gravada na BD e foi-lhe atribuído o ID " + despesa.getId());
        return "result";
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public String getInfo(ModelMap model, @PathVariable("id") Long id) {

        Despesa despesa = em.find(Despesa.class, id);

        model.put("despesa", despesa);

        return "info";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(ModelMap model, @PathVariable("id") Long id) {
        Despesa despesa = em.find(Despesa.class, id);
        DespesaForm despesaForm = new DespesaForm();
        despesaForm.setId(despesa.getId());
        despesaForm.setCategoria(despesa.getCategoria());
        despesaForm.setData(despesa.getData());
        despesaForm.setDescricao(despesa.getDescricao());
        despesaForm.setValor(despesa.getValor());
        despesaForm.setLocalizacao(despesa.getLocalizacao());

        model.put("despesaForm", despesaForm);

        return "form";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(ModelMap model, @PathVariable("id") Long id) {

        Despesa despesa = em.find(Despesa.class, id);

        String data1 = despesa.getData();
        String[] parts = data1.split("-");
        int month1 = Integer.parseInt(parts[1]);

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month2 = localDate.getMonthValue();


        if(month1 == month2){
            em.remove(despesa);

            model.addAttribute("message", "Sucesso! A despesa de " + despesa.getCategoria() + " no dia " + despesa.getData() + " foi eliminada");
        } else {
            model.addAttribute("message", "Não pode remover despesas de meses anteriores.");
        }

        return "result";
    }

    @RequestMapping(value = "/mapa", method = RequestMethod.GET)
    public String getMap(ModelMap model){

        float janTransportes = 0.0f, janAlimentacao = 0.0f, janPropinas = 0.0f, janRenda = 0.0f, janOutro = 0.0f, janTotal = 0.0f;
        float fevTransportes = 0.0f, fevAlimentacao = 0.0f, fevPropinas = 0.0f, fevRenda = 0.0f, fevOutro = 0.0f, fevTotal = 0.0f, fevVariacao = 0.0f;
        float marTransportes = 0.0f, marAlimentacao = 0.0f, marPropinas = 0.0f, marRenda = 0.0f, marOutro = 0.0f, marTotal = 0.0f, marVariacao = 0.0f;
        float abrTransportes = 0.0f, abrAlimentacao = 0.0f, abrPropinas = 0.0f, abrRenda = 0.0f, abrOutro = 0.0f, abrTotal = 0.0f, abrVariacao = 0.0f;
        float maiTransportes = 0.0f, maiAlimentacao = 0.0f, maiPropinas = 0.0f, maiRenda = 0.0f, maiOutro = 0.0f, maiTotal = 0.0f, maiVariacao = 0.0f;
        float junTransportes = 0.0f, junAlimentacao = 0.0f, junPropinas = 0.0f, junRenda = 0.0f, junOutro = 0.0f, junTotal = 0.0f, junVariacao = 0.0f;
        float julTransportes = 0.0f, julAlimentacao = 0.0f, julPropinas = 0.0f, julRenda = 0.0f, julOutro = 0.0f, julTotal = 0.0f, julVariacao = 0.0f;
        float agoTransportes = 0.0f, agoAlimentacao = 0.0f, agoPropinas = 0.0f, agoRenda = 0.0f, agoOutro = 0.0f, agoTotal = 0.0f, agoVariacao = 0.0f;
        float setTransportes = 0.0f, setAlimentacao = 0.0f, setPropinas = 0.0f, setRenda = 0.0f, setOutro = 0.0f, setTotal = 0.0f, setVariacao = 0.0f;
        float outTransportes = 0.0f, outAlimentacao = 0.0f, outPropinas = 0.0f, outRenda = 0.0f, outOutro = 0.0f, outTotal = 0.0f, outVariacao = 0.0f;
        float novTransportes = 0.0f, novAlimentacao = 0.0f, novPropinas = 0.0f, novRenda = 0.0f, novOutro = 0.0f, novTotal = 0.0f, novVariacao = 0.0f;
        float dezTransportes = 0.0f, dezAlimentacao = 0.0f, dezPropinas = 0.0f, dezRenda = 0.0f, dezOutro = 0.0f, dezTotal = 0.0f, dezVariacao = 0.0f;

        float totalTransportes = 0.0f, totalAlimentacao = 0.0f, totalPropinas = 0.0f, totalRenda = 0.0f, totalOutro = 0.0f, totalTotal = 0.0f;

        try{
            Query query = em.createQuery("SELECT MAX(d.id) FROM Despesa d");
            long idMax = (Long)query.getSingleResult();

            for (long id = 1; id < idMax; id++) {

                Despesa despesa = em.find(Despesa.class, id);

                String data = despesa.getData();
                String[] parts = data.split("-");
                int month = Integer.parseInt(parts[1]);

                int year = Integer.parseInt(parts[0]);

                Date date = new Date();
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int yearLocal = localDate.getYear();

                if(year == yearLocal) {
                    if (month == 1) {
                        if (Objects.equals(despesa.getCategoria(), "Transportes")) {
                            janTransportes = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                            janAlimentacao = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                            janPropinas = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                            janRenda = +despesa.getValor();
                        } else {
                            janOutro = +despesa.getValor();
                        }
                    }
                    if (month == 2) {
                        if (Objects.equals(despesa.getCategoria(), "Transportes")) {
                            fevTransportes = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                            fevAlimentacao = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                            fevPropinas = +despesa.getValor();
                            model.addAttribute("fevPropinas", fevPropinas);
                        } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                            fevRenda = +despesa.getValor();
                        } else {
                            fevOutro = +despesa.getValor();
                        }
                    }
                    if (month == 3) {
                        if (Objects.equals(despesa.getCategoria(), "Transportes")) {
                            marTransportes = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                            marAlimentacao = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                            marPropinas = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                            marRenda = +despesa.getValor();
                        } else {
                            marOutro = +despesa.getValor();
                        }
                    }
                    if (month == 4) {
                        if (Objects.equals(despesa.getCategoria(), "Transportes")) {
                            abrTransportes = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                            abrAlimentacao = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                            abrPropinas = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                            abrRenda = +despesa.getValor();
                        } else {
                            abrOutro = +despesa.getValor();
                        }
                    }
                    if (month == 5) {
                        if (Objects.equals(despesa.getCategoria(), "Transportes")) {
                            maiTransportes = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                            maiAlimentacao = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                            maiPropinas = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                            maiRenda = +despesa.getValor();
                        } else {
                            maiOutro = +despesa.getValor();
                        }
                    }
                    if (month == 6) {
                        if (Objects.equals(despesa.getCategoria(), "Transportes")) {
                            junTransportes = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                            junAlimentacao = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                            junPropinas = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                            junRenda = +despesa.getValor();
                        } else {
                            junOutro = +despesa.getValor();
                        }
                    }
                    if (month == 7) {
                        if (Objects.equals(despesa.getCategoria(), "Transportes")) {
                            julTransportes = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                            julAlimentacao = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                            julPropinas = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                            julRenda = +despesa.getValor();
                        } else {
                            julOutro = +despesa.getValor();
                        }
                    }
                    if (month == 8) {
                        if (Objects.equals(despesa.getCategoria(), "Transportes")) {
                            agoTransportes = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                            agoAlimentacao = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                            agoPropinas = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                            agoRenda = +despesa.getValor();
                        } else {
                            agoOutro = +despesa.getValor();
                        }
                    }
                    if (month == 9) {
                        if (Objects.equals(despesa.getCategoria(), "Transportes")) {
                            setTransportes = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                            setAlimentacao = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                            setPropinas = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                            setRenda = +despesa.getValor();
                        } else {
                            setOutro = +despesa.getValor();
                        }
                    }
                    if (month == 10) {
                        if (Objects.equals(despesa.getCategoria(), "Transportes")) {
                            outTransportes = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                            outAlimentacao = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                            outPropinas = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                            outRenda = +despesa.getValor();
                        } else {
                            outOutro = +despesa.getValor();
                        }
                    }
                    if (month == 11) {
                        if (Objects.equals(despesa.getCategoria(), "Transportes")) {
                            novTransportes = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                            novAlimentacao = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                            novPropinas = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                            novRenda = +despesa.getValor();
                        } else {
                            novOutro = +despesa.getValor();
                        }
                    }
                    if (month == 12) {
                        if (Objects.equals(despesa.getCategoria(), "Transportes")) {
                            dezTransportes = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                            dezAlimentacao = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                            dezPropinas = +despesa.getValor();
                        } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                            dezRenda = +despesa.getValor();
                        } else {
                            dezOutro = +despesa.getValor();
                        }
                    }
                }

                janTotal = janTransportes + janAlimentacao + janPropinas + janRenda + janOutro;

                model.addAttribute("janTransportes", janTransportes);
                model.addAttribute("janAlimentacao", janAlimentacao);
                model.addAttribute("janPropinas", janPropinas);
                model.addAttribute("janRenda", janRenda);
                model.addAttribute("janOutro", janOutro);
                model.addAttribute("janTotal", janTotal);

                fevTotal = fevTransportes + fevAlimentacao + fevPropinas + fevRenda + fevOutro;
                fevVariacao = (((fevTotal - janTotal) * 100) / janTotal);

                model.addAttribute("fevTransportes", fevTransportes);
                model.addAttribute("fevAlimentacao", fevAlimentacao);
                model.addAttribute("fevPropinas", fevPropinas);
                model.addAttribute("fevRenda", fevRenda);
                model.addAttribute("fevOutro", fevOutro);
                model.addAttribute("fevTotal", fevTotal);
                model.addAttribute("fevVariacao", fevVariacao);

                marTotal = marTransportes + marAlimentacao + marPropinas + marRenda + marOutro;
                marVariacao = (((marTotal - fevTotal) * 100) / fevTotal);

                model.addAttribute("marTransportes", marTransportes);
                model.addAttribute("marAlimentacao", marAlimentacao);
                model.addAttribute("marPropinas", marPropinas);
                model.addAttribute("marRenda", marRenda);
                model.addAttribute("marOutro", marOutro);
                model.addAttribute("marTotal", marTotal);
                model.addAttribute("marVariacao", marVariacao);

                abrTotal = abrTransportes + abrAlimentacao + abrPropinas + abrRenda + abrOutro;
                abrVariacao = (((abrTotal - marTotal) * 100) / marTotal);

                model.addAttribute("abrTransportes", abrTransportes);
                model.addAttribute("abrAlimentacao", abrAlimentacao);
                model.addAttribute("abrPropinas", abrPropinas);
                model.addAttribute("abrRenda", abrRenda);
                model.addAttribute("abrOutro", abrOutro);
                model.addAttribute("abrTotal", abrTotal);
                model.addAttribute("abrVariacao", abrVariacao);

                maiTotal = maiTransportes + maiAlimentacao + maiPropinas + maiRenda + maiOutro;
                maiVariacao = (((maiTotal - abrTotal) * 100) / abrTotal);

                model.addAttribute("maiTransportes", maiTransportes);
                model.addAttribute("maiAlimentacao", maiAlimentacao);
                model.addAttribute("maiPropinas", maiPropinas);
                model.addAttribute("maiRenda", maiRenda);
                model.addAttribute("maiOutro", maiOutro);
                model.addAttribute("maiTotal", maiTotal);
                model.addAttribute("maiVariacao", maiVariacao);

                junTotal = junTransportes + junAlimentacao + junPropinas + junRenda + junOutro;
                junVariacao = (((junTotal - maiTotal) * 100) / maiTotal);

                model.addAttribute("junTransportes", junTransportes);
                model.addAttribute("junAlimentacao", junAlimentacao);
                model.addAttribute("junPropinas", junPropinas);
                model.addAttribute("junRenda", junRenda);
                model.addAttribute("junOutro", junOutro);
                model.addAttribute("junTotal", junTotal);
                model.addAttribute("junVariacao", junVariacao);

                julTotal = julTransportes + julAlimentacao + julPropinas + julRenda + julOutro;
                julVariacao = (((julTotal - junTotal) * 100) / junTotal);

                model.addAttribute("julTransportes", julTransportes);
                model.addAttribute("julAlimentacao", julAlimentacao);
                model.addAttribute("julPropinas", julPropinas);
                model.addAttribute("julRenda", julRenda);
                model.addAttribute("julOutro", julOutro);
                model.addAttribute("julTotal", julTotal);
                model.addAttribute("julVariacao", julVariacao);

                agoTotal = agoTransportes + agoAlimentacao + agoPropinas + agoRenda + agoOutro;
                agoVariacao = (((agoTotal - julTotal) * 100) / julTotal);

                model.addAttribute("agoTransportes", agoTransportes);
                model.addAttribute("agoAlimentacao", agoAlimentacao);
                model.addAttribute("agoPropinas", agoPropinas);
                model.addAttribute("agoRenda", agoRenda);
                model.addAttribute("agoOutro", agoOutro);
                model.addAttribute("agoTotal", agoTotal);
                model.addAttribute("agoVariacao", agoVariacao);

                setTotal = setTransportes + setAlimentacao + setPropinas + setRenda + setOutro;
                setVariacao = (((setTotal - agoTotal) * 100) / agoTotal);

                model.addAttribute("setTransportes", setTransportes);
                model.addAttribute("setAlimentacao", setAlimentacao);
                model.addAttribute("setPropinas", setPropinas);
                model.addAttribute("setRenda", setRenda);
                model.addAttribute("setOutro", setOutro);
                model.addAttribute("setTotal", setTotal);
                model.addAttribute("setVariacao", setVariacao);

                outTotal = outTransportes + outAlimentacao + outPropinas + outRenda + outOutro;
                outVariacao = (((outTotal - setTotal) * 100) / setTotal);

                model.addAttribute("outTransportes", outTransportes);
                model.addAttribute("outAlimentacao", outAlimentacao);
                model.addAttribute("outPropinas", outPropinas);
                model.addAttribute("outRenda", outRenda);
                model.addAttribute("outOutro", outOutro);
                model.addAttribute("outTotal", outTotal);
                model.addAttribute("outVariacao", outVariacao);

                novTotal = novTransportes + novAlimentacao + novPropinas + novRenda + novOutro;
                novVariacao = (((novTotal - outTotal) * 100) / outTotal);

                model.addAttribute("novTransportes", novTransportes);
                model.addAttribute("novAlimentacao", novAlimentacao);
                model.addAttribute("novPropinas", novPropinas);
                model.addAttribute("novRenda", novRenda);
                model.addAttribute("novOutro", novOutro);
                model.addAttribute("novTotal", novTotal);
                model.addAttribute("novVariacao", novVariacao);

                dezTotal = dezTransportes + dezAlimentacao + dezPropinas + dezRenda + dezOutro;
                dezVariacao = (((dezTotal - novTotal) * 100) / novTotal);

                model.addAttribute("dezTransportes", dezTransportes);
                model.addAttribute("dezAlimentacao", dezAlimentacao);
                model.addAttribute("dezPropinas", dezPropinas);
                model.addAttribute("dezRenda", dezRenda);
                model.addAttribute("dezOutro", dezOutro);
                model.addAttribute("dezTotal", dezTotal);
                model.addAttribute("dezVariacao", dezVariacao);

                totalTransportes = janTransportes + fevTransportes + marTransportes + abrTransportes + maiTransportes + junTransportes + julTransportes + agoTransportes + setTransportes + outTransportes + novTransportes + dezTransportes;
                totalAlimentacao = janAlimentacao + fevAlimentacao + marAlimentacao + abrAlimentacao + maiAlimentacao + junAlimentacao + julAlimentacao + agoAlimentacao + setAlimentacao + outAlimentacao + novAlimentacao + dezAlimentacao;
                totalPropinas = janPropinas + fevPropinas + marPropinas + abrPropinas + maiPropinas + junPropinas + julPropinas + agoPropinas + setPropinas + outPropinas + novPropinas + dezPropinas;
                totalRenda = janRenda + fevRenda + marRenda + abrRenda + maiRenda + junRenda + julRenda + agoRenda + setRenda + outRenda + novRenda + dezRenda;
                totalOutro = janOutro + fevOutro + marOutro + abrOutro + maiOutro + junOutro + julOutro + agoOutro + setOutro + outOutro + novOutro + dezOutro;
                totalTotal = totalTransportes + totalAlimentacao + totalPropinas + totalRenda + totalOutro;

                model.addAttribute("totalTransportes", totalTransportes);
                model.addAttribute("totalAlimentacao", totalAlimentacao);
                model.addAttribute("totalPropinas", totalPropinas);
                model.addAttribute("totalRenda", totalRenda);
                model.addAttribute("totalOutro", totalOutro);
                model.addAttribute("totalTotal", totalTotal);
            }
            return "mapa";

        } catch (java.lang.NullPointerException e){
        model.addAttribute("message", "Não tem despesas.");

        return "result";
    }
    }
}

