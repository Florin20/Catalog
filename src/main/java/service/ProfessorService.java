package service;

import dao.ProfessorDAO;

public class ProfessorService {

    private ProfessorDAO pdao = new ProfessorDAO();

    public void initialize(){
        pdao.initialize();
    }
}
