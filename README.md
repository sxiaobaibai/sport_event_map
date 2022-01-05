# sport_event_map

## 準備
PostgreSQLのデータベースが必要。
java側の設定はsrc/main/resources/application.propertiesに書いてあるが、デフォルトではDBサーバは以下のものを使用している。
データベース名: sport_event_db
ユーザ名: xiaobai
また、テーブルなどの情報はmain/src/data_initialize/postgresql/insert_datas_for_sport_event_db.sqlを参考にしてください。
現状では、イベントの情報は手動で入れています。

## アプリケーションサーバの実行方法
```
mvn compile exec:java -Dexec.mainClass=.jp.co.xiaobai.MyApplication
```
http://localhost:3000/ にてアクセス可能

## 指定した日のイベント情報を表示
http://localhost:3000/event/{yyyy-mm-dd} にてアクセスするとyyyy年mm月dd日の大会情報が地図に表示される。
