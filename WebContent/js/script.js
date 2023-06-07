/**確認ダイアログコピペ
 * https://www.tagindex.com/javascript/form/submit.html
 */
function check(){
	if(window.confirm('会員情報を削除しますか？')){ // 確認ダイアログを表示
		return true; // 「OK」時は送信を実行
	}
	else{ // 「キャンセル」時の処理
		window.alert('キャンセルされました'); // 警告ダイアログを表示
		return false; // 送信を中止
	}
}