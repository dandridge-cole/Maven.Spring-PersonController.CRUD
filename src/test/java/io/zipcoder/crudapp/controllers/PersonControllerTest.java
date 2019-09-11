package io.zipcoder.crudapp.controllers;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.repositories.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
//import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonController personController;

    @Test
    public void createPerson() {
        Person p = createPersonMock();
        when(personController.createPerson(p)).thenReturn((p));
        personController.createPerson(p);
        verify(personRepository, times(1)).save(p);
    }

    @Test
    public void getPerson() {
        Person p = createPersonMock();
        when(personController.getPerson(2)).thenReturn(p);
        personController.getPerson(2);
        verify(personRepository, times(1)).getById(2);
    }

    @Test
    public void getPersonList() {
        when(personController.getPersonList()).thenReturn(subData());
        personController.getPersonList();
        verify(personRepository, times(1)).findAll();
    }

    @Test
    public void updatePerson() {
        Person p = createPersonMock();
        when(personController.updatePerson(p)).thenReturn(p);
        personController.updatePerson(p);
        verify(personRepository, times(1)).save(p);
    }

    @Test
    public void deletePerson() {
        personController.deletePerson(2);
        verify(personRepository, times(1)).delete(2);
    }

    private List<Person> subData() {return Arrays.asList(new Person(), new Person());}

    private Person createPersonMock(){return new Person();}
}