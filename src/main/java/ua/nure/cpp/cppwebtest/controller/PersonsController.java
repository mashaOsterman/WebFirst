package ua.nure.cpp.cppwebtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.nure.cpp.cppwebtest.DAO.DAOConfig;
import ua.nure.cpp.cppwebtest.DAO.DomaonDao;
import ua.nure.cpp.cppwebtest.DAO.entity.Person;
import ua.nure.cpp.cppwebtest.DAO.mysql.MySqlDomaonDao;
import ua.nure.cpp.cppwebtest.form.AddPersonForm;
import ua.nure.cpp.cppwebtest.form.DeletePersonForm;
import ua.nure.cpp.cppwebtest.form.FindPersonByNameForm;

import java.sql.SQLException;
import java.util.List;

@Controller
public class PersonsController {


    private DomaonDao dao = new MySqlDomaonDao();
    @RequestMapping(value ={ "/", "/persons"},  method = {RequestMethod.GET, RequestMethod.POST})
    public String getAllPersons(Model model) throws SQLException {
        List<Person> list = dao.getAllPersons();

        model.addAttribute("allPersons", list);
        return "personsPage";
    }
    @GetMapping(value = {"/addPerson"})
    public String showAddPersonView(Model model) {
        AddPersonForm addPersonForm = new AddPersonForm();
        model.addAttribute("addPersonForm", addPersonForm);
        return "addPersonPage";
    }
    @PostMapping(value = {"/addPerson"})
    public String addPerson(Model model, AddPersonForm addPersonForm) throws SQLException {
        // validate adStudentForm object
        dao.addNewPerson(new Person(addPersonForm.getFirst_name(), addPersonForm.getSecond_name(), addPersonForm.getAddress(),
                addPersonForm.getPhone_number(), addPersonForm.getSettlement_account()));
        return "redirect:/persons";
    }
    @GetMapping(value = {"/deletePersonsByName"})
    public String showDeletePersonView(Model model) {
        DeletePersonForm deletePersonForm = new DeletePersonForm();
        model.addAttribute("DeletePersonForm", deletePersonForm);
        return "deletePersonsByNamePage";
    }
    @PostMapping(value = {"/deletePersonsByName"})
    public String deleteStudent(Model model, DeletePersonForm deletePersonForm) throws SQLException {
        dao.deletePerson(deletePersonForm.getName());
        return "redirect:/persons";
    }
    @GetMapping(value = { "/personByName" })
    public String showFindPersonByNameView(Model model) {
        FindPersonByNameForm findPersonByNameForm = new FindPersonByNameForm();
        model.addAttribute("findPersonByNameForm", findPersonByNameForm);
        return "showFindPersonByNamePage";
    }

    @PostMapping(value = { "/personByName" })
    public String findBuyerByName(Model model, FindPersonByNameForm findPersonByNameForm) throws SQLException {
        List<Person> list = dao.findPersonsbyName(findPersonByNameForm.getNameOfPerson());
        model.addAttribute("allPersons", list);
        return "personsPage";
    }


}
