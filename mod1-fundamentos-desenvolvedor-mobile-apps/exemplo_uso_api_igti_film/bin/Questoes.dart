import 'package:collection/collection.dart';
import 'Account.dart';

void exercicio1(List<Account> accounts) {
  var total = accounts
      .map((e) => e.balance)
      .reduce((value, element) => value + element);

  print('Valor total de saldo somando as agências: ${total}');
}

void exercicio2(List<Account> accounts) {
  var accountsAboveBalance100 =
      accounts.where((element) => element.balance > 100).toList();

  print(
      'Contas com saldo acima de 100 reais: ${accountsAboveBalance100.length}');
}

void exercicio3(List<Account> accounts) {
  var accountsAboveBalance100WhereAgengy33 = accounts
      .where((element) => element.balance > 100 && element.agency == 33)
      .toList();

  print(
      'Contas com saldo acima de 100 reais na agência 33: ${accountsAboveBalance100WhereAgengy33.length}');
}

void exercicio4E5(List<Account> accounts) {
  var sortedAccountsByBalance = sortedByBalance(accounts);

  print(
      'Agência com a conta de menor saldo: ${sortedAccountsByBalance[0].agency} - Total de Saldo: ${sortedAccountsByBalance[0].balance}');
  print(
      'Agência com a conta de maior saldo: ${sortedAccountsByBalance[sortedAccountsByBalance.length - 1].agency} - Total de Saldo: ${sortedAccountsByBalance[sortedAccountsByBalance.length - 1].balance}');
}

void exercicio6(List<Account> accounts) {
  var mapAccountsByAgency = groupBy(accounts, (element) => element.agency);
  var totalMaxAccounts = 0;

  mapAccountsByAgency.forEach((key, value) {
    var listSorted = sortedByBalance(value);
    totalMaxAccounts += listSorted[listSorted.length - 1].balance;
  });

  print(
      'Total somando as contas de maiores saldos de cada agência: ${totalMaxAccounts}');
}

void exercicio7(List<Account> accounts) {
  var sortedAccountsByBalanceAgency10 = sortedByBalance(
      accounts.where((element) => element.agency == 10).toList());
  print(
      'Nome da pessoa com maior saldo da Agência 10: ${sortedAccountsByBalanceAgency10[sortedAccountsByBalanceAgency10.length - 1].name}');
}

void exercicio8(List<Account> accounts) {
  var sortedAccountsByBalanceAgency47 = sortedByBalance(
      accounts.where((element) => element.agency == 47).toList());
  print(
      'Nome da pessoa com menor saldo da Agência 47: ${sortedAccountsByBalanceAgency47[0].name}');
}

void exercicio9(List<Account> accounts) {
  var sortedAccountsByBalanceAgency47 = sortedByBalance(
      accounts.where((element) => element.agency == 47).toList());
  var name3lowestBalances =
      sortedAccountsByBalanceAgency47.take(3).map((e) => e.name).join(", ");
  print(
      'Nome das 3 pessoas com menores saldos da Agência 47: ${name3lowestBalances}');
}

void exercicio10(List<Account> accounts) {
  var accountsByAgency47 =
      accounts.where((element) => element.agency == 47).toList();
  print('Quantidade de contas na agência 47: ${accountsByAgency47.length}');
}

void exercicio11(List<Account> accounts) {
  var accountsNameMariaByAgency47 = accounts
      .where(
          (element) => element.agency == 47 && element.name.contains('Maria'))
      .toList();
  print(
      'Quantidade de contas com "Maria" na agência 47: ${accountsNameMariaByAgency47.length}');
}

void exercicio12(List<Account> accounts) {
  var sortedAccountsById = [...accounts];
  sortedAccountsById.sort((a, b) => a.id.compareTo(b.id));
  var nextId = sortedAccountsById[sortedAccountsById.length - 1].id + 1;

  print('Próximo id disponível: ${nextId}');
}

List<Account> sortedByBalance(List<Account> accounts) {
  var sortedAccountsByBalance = [...accounts];
  sortedAccountsByBalance.sort((a, b) => a.balance.compareTo(b.balance));
  return sortedAccountsByBalance;
}