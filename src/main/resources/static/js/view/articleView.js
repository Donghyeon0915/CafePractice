function availableCheck(){
    const userNickname = document.querySelector('#hidden_user_nickname').value;
    const author = document.querySelector('#hidden_article_author').value;

    if(userNickname != author){
        document.querySelector('#article_edit_btn').remove();
        //classList.add("hidden");
        document.querySelector('#article_delete_btn').remove();
        //.classList.add("hidden");
    }
}