package cn.towerman1990.learn_thrift.impl;

import cn.towerman1990.learn_thrift.model.BookModel;
import cn.towerman1990.learn_thrift.model.Status;
import cn.towerman1990.learn_thrift.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookModelServiceImpl implements BookService.Iface {

    @Override
    public cn.towerman1990.learn_thrift.model.BookModel getById(int id) {
        // todo
        // find data from database, then transfer to BookModel;
        var bookModel = new BookModel();
        bookModel.setId(id);
        bookModel.setType("小说");
        bookModel.setName("《红楼梦》");
        bookModel.setDescription("《红楼梦》，中国古典长篇章回小说，是中国四大小说名著。");
        bookModel.setStatus(Status.YES);
        return bookModel;
    }

    @Override
    public cn.towerman1990.learn_thrift.model.BookModel create(cn.towerman1990.learn_thrift.model.BookModel bookModel) {
        return bookModel;
    }

    @Override
    public cn.towerman1990.learn_thrift.model.BookModel update(cn.towerman1990.learn_thrift.model.BookModel bookModel) {
        return bookModel;
    }

    @Override
    public List<cn.towerman1990.learn_thrift.model.BookModel> getList() {
        return new ArrayList<>();
    }
}
