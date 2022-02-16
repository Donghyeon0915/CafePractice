function availableCheck(){
    const userNickname = document.querySelector('#hidden_user_nickname').value;
    const author = document.querySelector('#hidden_article_author').value;

    alert(userNickname + " + " + author);

    if(userNickname == author){
        alert('게시글 관리 가능');
        document.getElementById('#article_edit_btn').style.visibility = "hidden";
        document.getElementById('#article_delete_btn').style.visibility = "hidden";
    }
}