
import 'dart:convert';
import 'Account.dart';
import 'package:http/http.dart';

void main(List<String> arguments) {
  load_accounts();
}


  Future<List<Account>> load_accounts() async {
    var url = 'https://igti-film.herokuapp.com/api/accounts';

    var response = await get(url);
    var json = jsonDecode(response.body);
 
    print(json);
    return List<Account>.from(
        json.map((item) => Account.fromJson(item)).toList());
  }
