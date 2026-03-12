package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.Materia;
import java.util.List;

public interface MateriaService {
    
    
    public List<Materia> getMaterias(boolean activos);
    
    
    public Materia getMateria(Materia materia);
    
    
    public void save(Materia materia);
    
    
    public void delete(Materia materia);
}