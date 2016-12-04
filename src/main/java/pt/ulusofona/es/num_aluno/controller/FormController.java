package pt.ulusofona.es.num_aluno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang.StringUtils;
import pt.ulusofona.es.num_aluno.data.Despesa;
import pt.ulusofona.es.num_aluno.form.DespesaForm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

        long id=1;
        float janTransportes = 0, janAlimentacao = 0, janPropinas = 0, janRenda = 0;
        float fevTransportes = 0, fevAlimentacao = 0, fevPropinas = 0, fevRenda = 0;
        float marTransportes = 0, marAlimentacao = 0, marPropinas = 0, marRenda = 0;
        float abrTransportes = 0, abrAlimentacao = 0, abrPropinas = 0, abrRenda = 0;
        float maiTransportes = 0, maiAlimentacao = 0, maiPropinas = 0, maiRenda = 0;
        float junTransportes = 0, junAlimentacao = 0, junPropinas = 0, junRenda = 0;
        float julTransportes = 0, julAlimentacao = 0, julPropinas = 0, julRenda = 0;
        float agoTransportes = 0, agoAlimentacao = 0, agoPropinas = 0, agoRenda = 0;
        float setTransportes = 0, setAlimentacao = 0, setPropinas = 0, setRenda = 0;
        float outTransportes = 0, outAlimentacao = 0, outPropinas = 0, outRenda = 0;
        float novTransportes = 0, novAlimentacao = 0, novPropinas = 0, novRenda = 0;
        float dezTransportes = 0, dezAlimentacao = 0, dezPropinas = 0, dezRenda = 0;


        for (int i=0; i<id; i++) {

            Despesa despesa = em.find(Despesa.class, id);

            String data = despesa.getData();
            String[] parts = data.split("-");
            int month = Integer.parseInt(parts[1]);

            if (month == 1) {
                if (Objects.equals(despesa.getCategoria(), "Tranportes")) {
                    janTransportes =+ despesa.getValor();
                    model.addAttribute("janTransportes", janTransportes);
                } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                    janAlimentacao =+ despesa.getValor();
                    model.addAttribute("janAlimentacao", janAlimentacao);
                } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                    janPropinas =+ despesa.getValor();
                    model.addAttribute("janPropinas", janPropinas);
                } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                    janRenda =+ despesa.getValor();
                    model.addAttribute("janRenda", janRenda);
                } else {
                    model.addAttribute("janTotal", janTransportes + janAlimentacao + janPropinas + janRenda);
                }
            }
            if (month == 2) {
                if (Objects.equals(despesa.getCategoria(), "Tranportes")) {
                    fevTransportes =+ despesa.getValor();
                    model.addAttribute("fevTransportes", fevTransportes);
                } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                    fevAlimentacao =+ despesa.getValor();
                    model.addAttribute("fevAlimentacao", fevAlimentacao);
                } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                    fevPropinas =+ despesa.getValor();
                    model.addAttribute("fevPropinas", fevPropinas);
                } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                    fevRenda =+ despesa.getValor();
                    model.addAttribute("fevRenda", fevRenda);
                } else {
                    model.addAttribute("fevTotal", fevTransportes + fevAlimentacao + fevPropinas + fevRenda);
                }
            }
            if (month == 3) {
                if (Objects.equals(despesa.getCategoria(), "Tranportes")) {
                    marTransportes =+ despesa.getValor();
                    model.addAttribute("marTransportes", marTransportes);
                } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                    marAlimentacao =+ despesa.getValor();
                    model.addAttribute("marAlimentacao", marAlimentacao);
                } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                    marPropinas =+ despesa.getValor();
                    model.addAttribute("marPropinas", marPropinas);
                } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                    marRenda =+ despesa.getValor();
                    model.addAttribute("marRenda", marRenda);
                } else {
                    model.addAttribute("marTotal", marTransportes + marAlimentacao + marPropinas + marRenda);
                }
            }
            if (month == 4) {
                if (Objects.equals(despesa.getCategoria(), "Tranportes")) {
                    abrTransportes =+ despesa.getValor();
                    model.addAttribute("abrTransportes", abrTransportes);
                } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                    abrAlimentacao =+ despesa.getValor();
                    model.addAttribute("abrAlimentacao", abrAlimentacao);
                } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                    abrPropinas =+ despesa.getValor();
                    model.addAttribute("abrPropinas", abrPropinas);
                } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                    abrRenda =+ despesa.getValor();
                    model.addAttribute("abrRenda", abrRenda);
                } else {
                    model.addAttribute("abrTotal", abrTransportes + abrAlimentacao + abrPropinas + abrRenda);
                }
            }
            if (month == 5) {
                if (Objects.equals(despesa.getCategoria(), "Tranportes")) {
                    maiTransportes =+ despesa.getValor();
                    model.addAttribute("maiTransportes", maiTransportes);
                } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                    maiAlimentacao =+ despesa.getValor();
                    model.addAttribute("maiAlimentacao", maiAlimentacao);
                } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                    maiPropinas =+ despesa.getValor();
                    model.addAttribute("maiPropinas", maiPropinas);
                } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                    maiRenda =+ despesa.getValor();
                    model.addAttribute("maiRenda", maiRenda);
                } else {
                    model.addAttribute("maiTotal", maiTransportes + maiAlimentacao + maiPropinas + maiRenda);
                }
            }
            if (month == 6) {
                if (Objects.equals(despesa.getCategoria(), "Tranportes")) {
                    junTransportes =+ despesa.getValor();
                    model.addAttribute("junTransportes", junTransportes);
                } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                    junAlimentacao =+ despesa.getValor();
                    model.addAttribute("junAlimentacao", junAlimentacao);
                } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                    junPropinas =+ despesa.getValor();
                    model.addAttribute("junPropinas", junPropinas);
                } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                    junRenda =+ despesa.getValor();
                    model.addAttribute("junRenda", junRenda);
                } else {
                    model.addAttribute("junTotal", junTransportes + junAlimentacao + junPropinas + junRenda);
                }
            }
            if (month == 7) {
                if (Objects.equals(despesa.getCategoria(), "Tranportes")) {
                    julTransportes =+ despesa.getValor();
                    model.addAttribute("julTransportes", julTransportes);
                } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                    julAlimentacao =+ despesa.getValor();
                    model.addAttribute("julAlimentacao", julAlimentacao);
                } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                    julPropinas =+ despesa.getValor();
                    model.addAttribute("julPropinas", julPropinas);
                } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                    julRenda =+ despesa.getValor();
                    model.addAttribute("julRenda", julRenda);
                } else {
                    model.addAttribute("julTotal", julTransportes + julAlimentacao + julPropinas + julRenda);
                }
            }
            if (month == 8) {
                if (Objects.equals(despesa.getCategoria(), "Tranportes")) {
                    agoTransportes =+ despesa.getValor();
                    model.addAttribute("agoTransportes", agoTransportes);
                } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                    agoAlimentacao =+ despesa.getValor();
                    model.addAttribute("agoAlimentacao", agoAlimentacao);
                } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                    agoPropinas =+ despesa.getValor();
                    model.addAttribute("agoPropinas", agoPropinas);
                } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                    agoRenda =+ despesa.getValor();
                    model.addAttribute("agoRenda", agoRenda);
                } else {
                    model.addAttribute("agoTotal", agoTransportes + agoAlimentacao + agoPropinas + agoRenda);
                }
            }
            if (month == 9) {
                if (Objects.equals(despesa.getCategoria(), "Tranportes")) {
                    setTransportes =+ despesa.getValor();
                    model.addAttribute("setTransportes", setTransportes);
                } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                    setAlimentacao =+ despesa.getValor();
                    model.addAttribute("setAlimentacao", setAlimentacao);
                } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                    setPropinas =+ despesa.getValor();
                    model.addAttribute("setPropinas", setPropinas);
                } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                    setRenda =+ despesa.getValor();
                    model.addAttribute("setRenda", setRenda);
                } else {
                    model.addAttribute("setTotal", setTransportes + setAlimentacao + setPropinas + setRenda);
                }
            }
            if (month == 10) {
                if (Objects.equals(despesa.getCategoria(), "Tranportes")) {
                    outTransportes =+ despesa.getValor();
                    model.addAttribute("outTransportes", outTransportes);
                } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                    outAlimentacao =+ despesa.getValor();
                    model.addAttribute("outAlimentacao", outAlimentacao);
                } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                    outPropinas =+ despesa.getValor();
                    model.addAttribute("outPropinas", outPropinas);
                } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                    outRenda =+ despesa.getValor();
                    model.addAttribute("outRenda", marRenda);
                } else {
                    model.addAttribute("outTotal", outTransportes + outAlimentacao + outPropinas + outRenda);
                }
            }
            if (month == 11) {
                if (Objects.equals(despesa.getCategoria(), "Tranportes")) {
                    novTransportes =+ despesa.getValor();
                    model.addAttribute("novTransportes", novTransportes);
                } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                    novAlimentacao =+ despesa.getValor();
                    model.addAttribute("novAlimentacao", novAlimentacao);
                } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                    novPropinas =+ despesa.getValor();
                    model.addAttribute("novPropinas", novPropinas);
                } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                    novRenda =+ despesa.getValor();
                    model.addAttribute("novRenda", novRenda);
                } else {
                    model.addAttribute("novTotal", novTransportes + novAlimentacao + novPropinas + novRenda);
                }
            }
            if (month == 12) {
                if (Objects.equals(despesa.getCategoria(), "Tranportes")) {
                    dezTransportes = +despesa.getValor();
                    model.addAttribute("dezTransportes", dezTransportes);
                } else if (Objects.equals(despesa.getCategoria(), "Alimentação")) {
                    dezAlimentacao = +despesa.getValor();
                    model.addAttribute("dezAlimentacao", dezAlimentacao);
                } else if (Objects.equals(despesa.getCategoria(), "Propinas")) {
                    dezPropinas = +despesa.getValor();
                    model.addAttribute("dezPropinas", dezPropinas);
                } else if (Objects.equals(despesa.getCategoria(), "Renda")) {
                    dezRenda = +despesa.getValor();
                    model.addAttribute("dezRenda", dezRenda);
                } else {
                    model.addAttribute("dezTotal", dezTransportes + dezAlimentacao + dezPropinas + dezRenda);
                }
            } else {
                model.addAttribute("janTransportes", janTransportes);
                model.addAttribute("janAlimentacao", janAlimentacao);
                model.addAttribute("janPropinas", janPropinas);
                model.addAttribute("janRenda", janRenda);
                model.addAttribute("janTotal", janTransportes + janAlimentacao + janPropinas + janRenda);

                model.addAttribute("fevTransportes", fevTransportes);
                model.addAttribute("fevAlimentacao", fevAlimentacao);
                model.addAttribute("fevPropinas", fevPropinas);
                model.addAttribute("fevRenda", fevRenda);
                model.addAttribute("fevTotal", fevTransportes + fevAlimentacao + fevPropinas + fevRenda);

                model.addAttribute("marTransportes", marTransportes);
                model.addAttribute("marAlimentacao", marAlimentacao);
                model.addAttribute("marPropinas", marPropinas);
                model.addAttribute("marRenda", marRenda);
                model.addAttribute("marTotal", marTransportes + marAlimentacao + marPropinas + marRenda);

                model.addAttribute("abrTransportes", abrTransportes);
                model.addAttribute("abrAlimentacao", abrAlimentacao);
                model.addAttribute("abrPropinas", abrPropinas);
                model.addAttribute("abrRenda", abrRenda);
                model.addAttribute("abrTotal", abrTransportes + abrAlimentacao + abrPropinas + abrRenda);

                model.addAttribute("maiTransportes", maiTransportes);
                model.addAttribute("maiAlimentacao", maiAlimentacao);
                model.addAttribute("maiPropinas", maiPropinas);
                model.addAttribute("maiRenda", maiRenda);
                model.addAttribute("maiTotal", maiTransportes + maiAlimentacao + maiPropinas + maiRenda);

                model.addAttribute("junTransportes", junTransportes);
                model.addAttribute("junAlimentacao", junAlimentacao);
                model.addAttribute("junPropinas", junPropinas);
                model.addAttribute("junRenda", junRenda);
                model.addAttribute("junTotal", junTransportes + junAlimentacao + junPropinas + junRenda);

                model.addAttribute("julTransportes", julTransportes);
                model.addAttribute("julAlimentacao", julAlimentacao);
                model.addAttribute("julPropinas", julPropinas);
                model.addAttribute("julRenda", julRenda);
                model.addAttribute("julTotal", julTransportes + julAlimentacao + julPropinas + julRenda);

                model.addAttribute("agoTransportes", agoTransportes);
                model.addAttribute("agoAlimentacao", agoAlimentacao);
                model.addAttribute("agoPropinas", agoPropinas);
                model.addAttribute("agoRenda", agoRenda);
                model.addAttribute("agoTotal", agoTransportes + agoAlimentacao + agoPropinas + agoRenda);

                model.addAttribute("setTransportes", setTransportes);
                model.addAttribute("setAlimentacao", setAlimentacao);
                model.addAttribute("setPropinas", setPropinas);
                model.addAttribute("setRenda", setRenda);
                model.addAttribute("setTotal", setTransportes + setAlimentacao + setPropinas + setRenda);

                model.addAttribute("outTransportes", outTransportes);
                model.addAttribute("outAlimentacao", outAlimentacao);
                model.addAttribute("outPropinas", outPropinas);
                model.addAttribute("outRenda", outRenda);
                model.addAttribute("outTotal", outTransportes + outAlimentacao + outPropinas + outRenda);

                model.addAttribute("novTransportes", novTransportes);
                model.addAttribute("novAlimentacao", novAlimentacao);
                model.addAttribute("novPropinas", novPropinas);
                model.addAttribute("novRenda", novRenda);
                model.addAttribute("novTotal", novTransportes + novAlimentacao + novPropinas + novRenda);

                model.addAttribute("dezTransportes", dezTransportes);
                model.addAttribute("dezAlimentacao", dezAlimentacao);
                model.addAttribute("dezPropinas", dezPropinas);
                model.addAttribute("dezRenda", dezRenda);
                model.addAttribute("dezTotal", dezTransportes + dezAlimentacao + dezPropinas + dezRenda);

                id++;
            }
        }
        return "mapa";
    }
}

