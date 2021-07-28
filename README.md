# TodoSystem

##本システムの概要

本システムは担当者ごとに担当するタスクを管理・共有するためのものです。

１，Login画面からログインします。新規登録もこの画面からできます。
![login](https://user-images.githubusercontent.com/87798825/127274204-6c70e90b-3a01-40f0-bd89-46a6b8daab00.jpg)

２，作業一覧画面で担当者各自が担当する案件を確認することができます。新しい案件は作業登録ボタンで新たに登録することができます。
　　また、本画面で完了、更新、削除をすることができるほか、キーワードを入力して案件を検索することができます。
![todo](https://user-images.githubusercontent.com/87798825/127273656-f0d36bdf-4756-47f8-9ed6-59762251ab6e.jpg)

３，本システムはLogin画面でIDとパスワードを入力することでログインできますが、IDとパスワードを入力する必要があります。パスワードは新規登録で入力するため登録者側で把握できるようになっていますが、IDは仕様の関係上、データベースを見ないとわからない内容になっています。管理者側がデータベースを見て登録者側にIDを伝えてログインできるようにすることを想定しているためで、不便ですが本システムをご覧になる際はデータベースのuser2テーブル上にある登録された方のid番号を参照してそれをLogin画面でパスワードとともに入力してください。
