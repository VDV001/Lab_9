package com.boots.service;

import com.boots.entity.TablesReaderBook.Book;
import com.boots.entity.TablesReaderBook.Reader;
import com.boots.entity.TablesUserRole.Role;
import com.boots.entity.TablesUserRole.User;
//import com.boots.entity.TablesUserRole.UserRole;
import com.boots.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class FillWebService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    UserRepository userRepository;

    int ADMIN = 0;
    public  void  FillTables() {
        if (ADMIN < 1) {
            /** Создаем объекты классов для таблиц Book и Reader и заполняем их **/

            Book book_1 = new Book(1L, "Programming with C++");
            Book book_2 = new Book(2L, "Programming with Java");
            Book book_3 = new Book(3L, "Information security");
            Book book_4 = new Book(4L, "Best Italian food");
            Book book_5 = new Book(5L, "Best France food");
            Book book_6 = new Book(6L, "How to get five on programming?");
            Book book_7 = new Book(7L, "Hibernate in 24 hours");
            Book book_8 = new Book(8L, "Spring or nothing");



            Reader reader_1 = new Reader(1L, "Mark");
            Reader reader_2 = new Reader(2L, "Tom");
            Reader reader_3 = new Reader(3L, "Dr. Who");

            reader_1.add(book_1);
            reader_1.add(book_8);
            reader_2.add(book_7);
            reader_3.add(book_5);

            /** Создаем объекты классов для таблиц Role, User и заполняем их **/

            Role role_admin = new Role(2L, "ROLE_ADMIN");
            Role role_user = new Role(1L, "ROLE_USER");

            // пароль  = "admin". Записал ее как Хэш
//            User admin = new User(2L, "admin", "$2a$10$jeCQe4UwkH0lLKd3hGQFreXwhKBEvLuLoe7FwjEtVQX77v7hD.nMy");
            /** Сохраняем объекты в БД  **/

            bookRepository.save(book_1);
            bookRepository.save(book_2);
            bookRepository.save(book_3);
            bookRepository.save(book_4);
            bookRepository.save(book_5);
            bookRepository.save(book_6);
            bookRepository.save(book_7);
            bookRepository.save(book_8);

            readerRepository.save(reader_1);
            readerRepository.save(reader_2);
            readerRepository.save(reader_3);

            roleRepository.save(role_admin);
            roleRepository.save(role_user);

            /** После сохранения в БД ролей, устанавливаем User-у : admin роль - role_admin **/

//            admin.setRoles(Collections.singleton(role_admin));

//            userRepository.save(admin);

            roleRepository.save(role_admin);
            roleRepository.save(role_user);

            ADMIN++;
        }
    }

}
