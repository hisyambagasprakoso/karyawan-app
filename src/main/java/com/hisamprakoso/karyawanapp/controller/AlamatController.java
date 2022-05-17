package com.hisamprakoso.karyawanapp.controller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

import com.hisamprakoso.karyawanapp.entity.Alamat;
import com.hisamprakoso.karyawanapp.repository.AlamatDao;
import com.hisamprakoso.karyawanapp.repository.KaryawanDao;

/**
 * @author : hisam
 * @since : 05/04/22
 */
@Controller
public class AlamatController {

    @Autowired
    private KaryawanDao karyawanDao;

    @Autowired
    private AlamatDao alamatDao;

    @RequestMapping("/alamat/list")
    public String alamat(Model model, @PageableDefault(size = 5) Pageable pageable,
            @RequestParam(name = "value", required = false) String value) {
        if (value != null) {
            model.addAttribute("key", value);
            model.addAttribute("data", alamatDao.findByNamaContainingIgnoreCase(value, pageable));
            // model.addAttribute("karyawan",
            // karyawanDao.findByNamaContainingIgnoreCase(value, pageable));
        } else {
            model.addAttribute("data", alamatDao.findAll(pageable));
            // tes
            // model.addAttribute("karyawan", karyawanDao.findAll());
        }
        return "alamat/list";

    }

    // @GetMapping("/alamat/form")
    // public ModelMap tampilkanForms(@RequestParam(value = "id", required = false)
    // Alamat alamat, Model m) {
    // if (alamat == null) {
    // alamat = new Alamat();
    // }
    // m.addAttribute("alamat", alamat);
    // m.addAttribute("karyawan", karyawanDao.findAll());
    // // return "alamat/form";
    // }

    @GetMapping("/alamat/form")
    public String tampilkanForms(@RequestParam(value = "id", required = false) Alamat alamat, Model m) {
        if (alamat == null) {
            alamat = new Alamat();
        }
        m.addAttribute("alamat", alamat);
        m.addAttribute("karyawan", karyawanDao.findAll());
        // return new ModelMap("alamat", alamat);
        return "alamat/form";
    }

    // @PostMapping("/alamat/form")
    // public String simpan(@Valid @ModelAttribute("alamat") Alamat alamat,
    // BindingResult errors,
    // SessionStatus status) {
    // if (errors.hasErrors()) {
    // return "alamat/form";
    // }
    // // alamat.setId(alamat.getId());
    // // alamat.setNama(alamat.getNama());
    // // alamat.setAlamat(alamat.getAlamat());

    // alamatDao.save(alamat);

    // status.setComplete();
    // return "redirect:/alamat/list";
    // }

    @PostMapping("/alamat/form")
    public String simpan(@ModelAttribute @Valid Alamat alamat, BindingResult errors,
            SessionStatus status) {
        if (errors.hasErrors()) {
            return "alamat/form";
        }
        Session session = HibernateUtil.createSessionFactory().openSession();
        // Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("update alamat set nama=:n,alamat=:o,id_karyawan=:p where id=:i");
        q.setParameter("i", alamat.getId());
        q.setParameter("n", alamat.getNama());
        q.setParameter("o", alamat.getAlamat());
        q.setParameter("p", alamat.getKaryawan());

        int status1 = q.executeUpdate();
        System.out.println(status1);
        tx.commit();

        // alamatDao.save(alamat);
        // alamatDao.delete(alamat);
        status.setComplete();
        return "redirect:/alamat/list";
    }

    @GetMapping("/alamat/delete")
    public ModelMap deleteConfirm(@RequestParam(value = "id", required = true) Alamat alamat) {
        return new ModelMap("alamat", alamat);
    }

    @PostMapping("/alamat/delete")
    public Object delete(@ModelAttribute Alamat alamat, SessionStatus status) {
        try {
            alamatDao.delete(alamat);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityId", alamat.getNama())
                    .addObject("entityName", "Alamat")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink", "/alamat/list");
        }
        status.setComplete();
        return "redirect:/alamat/list";
    }
}