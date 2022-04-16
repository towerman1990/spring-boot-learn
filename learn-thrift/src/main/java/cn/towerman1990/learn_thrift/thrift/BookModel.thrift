namespace java cn.towerman1990.server.model

enum Status {
    No = 0;
    YES = 1;
}
struct BookModel {
    1: required i32 id;
    2: required string type;
    3: required string name;
    4: optional string description;
    5: required Status status;
}
