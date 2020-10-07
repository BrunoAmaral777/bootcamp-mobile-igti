class Account {
  int id, agency, number, balance;
  String name;

  Account.fromJson(dynamic json):
        id = json['id'],
        agency = json['agencia'],
        number = json['conta'],
        name = json['name'],
        balance = json['balance'];

  @override
  String toString() {
    return '{ id = ${id}, agencia = ${agency}, conta = ${number}, nome = ${name}, saldo = ${balance}}';
  }
}