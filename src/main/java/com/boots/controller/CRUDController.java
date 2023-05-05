package com.boots.controller;

import com.boots.entity.TablesReaderBook.Book;
import com.boots.entity.TablesReaderBook.Reader;
import com.boots.repository.BookRepository;
import com.boots.service.BookService;
import com.boots.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CRUDController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ReaderService readerService;

    @GetMapping("/tableBooks/addBooks")
    public String addBooks(Model model) {
        return "addBooks";
    }
    @PostMapping("/tableBooks/addBooks")
    public String confirm(@RequestParam String book_name, Model model){
        Book book = new Book(book_name);
        bookService.saveBook(book);
        return "redirect:/tableBooks";
    }

    /**             Редактирование книг             **/
    @GetMapping("/tableBooks/{id}/editBooks")
    public String editBooks(@PathVariable(value = "id") long id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book_name1", book.getName());
        return "editBooks";
    }
    @PostMapping("/tableBooks/{id}/editBooks")
    public String bookEditConfirm(@PathVariable(value = "id") long id, @RequestParam String book_name, Model model){
        Book book = bookService.findById(id);
        book.setName(book_name);
        bookService.saveBook(book);
        return "redirect:/tableBooks";
    }

    /**             Удаление книги              **/
    @PostMapping("/tableBooks/{id}/deleteBook")
    public String bookDelete(@PathVariable(value = "id") long id, Model model){
        System.out.println("777");
        bookService.deleteBook(id);
        return "redirect:/tableBooks";
    }

    /**------------------------------Читатель------------------------------**/
    @GetMapping("/tableReaders/addReaders")
    public String addReader(Model model) {
        return "addReaders";
    }

    @PostMapping("/tableReaders/addReaders")
    public String readerAddConfirm(@RequestParam String reader_name, Model model){
        Reader reader = new Reader(reader_name);
        readerService.saveReader(reader);
        System.out.println(reader.getName());
        return "redirect:/tableReaders";}

    /**             Редактирование читателя             **/
    @GetMapping("/tableReaders/{id}/editReader")
    public String editReaders(@PathVariable(value = "id") long id, Model model){
        Reader reader = readerService.findById(id);
        model.addAttribute("reader_name", reader.getName());
        return "editReader";
    }
    @PostMapping("/tableReaders/{id}/editReader")
    public String readerEditConfirm(@PathVariable(value = "id") long id, @RequestParam String reader_name, Model model){
        Reader reader = readerService.findById(id);
        reader.setName(reader_name);
        readerService.saveReader(reader);
        return "redirect:/tableReaders";
    }

    /**             Удаление читателя              **/
    @PostMapping("/tableReaders/{id}/deleteReader")
    public String readerDelete(@PathVariable(value = "id") long id, Model model){
        String tname;
        Reader reader = readerService.findById(id);
        reader.setDeleted(true);
        tname = reader.getName();
        reader.setName("1");
        readerService.saveReader(reader);
        reader.setName(tname);
        readerService.saveReader(reader);
        return "redirect:/tableReaders";
    }
}
