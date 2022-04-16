namespace java cn.towerman1990.server.service

include "BookModel.thrift"

exception InvalidOperationException {
    1: i32 code,
    2: string description
}

service BookService {

    BookModel.BookModel getById(1: i32 id) throws (1: InvalidOperationException e),

    BookModel.BookModel create(1:BookModel.BookModel bookModel) throws (1:InvalidOperationException e),

    BookModel.BookModel update(1:BookModel.BookModel bookModel) throws (1:InvalidOperationException e),

    list <BookModel.BookModel> getList() throws (1:InvalidOperationException e),
}