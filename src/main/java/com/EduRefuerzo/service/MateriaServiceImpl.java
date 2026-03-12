package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.MateriaDao;
import com.EduRefuerzo.domain.Materia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaDao materiaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Materia> getMaterias(boolean activos) {
        var lista = materiaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Materia getMateria(Materia materia) {
        return materiaDao.findById(materia.getIdMateria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Materia materia) {
        materiaDao.save(materia);
    }

    @Override
    @Transactional
    public void delete(Materia materia) {
        materiaDao.delete(materia);
    }
}