package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.TemaDao;
import com.EduRefuerzo.domain.Tema;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TemaServiceImpl implements TemaService {

    @Autowired
    private TemaDao temaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tema> getTemas(boolean activos) {
        var lista = temaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Tema getTema(Tema tema) {
        return temaDao.findById(tema.getIdTema()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Tema tema) {
        temaDao.save(tema);
    }

    @Override
    @Transactional
    public void delete(Tema tema) {
        temaDao.delete(tema);
    }
}