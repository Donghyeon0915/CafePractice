function createdComment(){
    const articleId = document.querySelector('#hidden_article_id').value;
    const nickname = document.querySelector('#hidden_user_nickname').value;
    const content = document.querySelector('#input_comment_content').value;

    if(content == ""){
        alert("댓글을 입력하세요.");
        return;
    }

    const data = {
        articleId: articleId,
        nickname: nickname,
        content: content
    }

    const url = `/api/articles/${articleId}/comments`;

    fetch(url,{
        method: "POST",
        body: JSON.stringify(data),
        headers:{
            "Content-Type" : "application/json"
        }
    }).then(response=>{
        if(response.ok) {
            alert("댓글이 등록 되었습니다.");
            window.location.href = `/articles/${articleId}`;
        }
        else alert("댓글 등록 오류");
    })
}

function updateComment(event){
    const target = event.currentTarget.parentNode.parentNode;

    const articleId = document.querySelector('#hidden_article_id').value;
    const id = target.querySelector('#hidden_comment_id');
    const content = target.querySelector('#comment_content');
    
    const data = {
        id: id.value,
        content: content.value
    }

    const url = `/api/articles/${articleId}/comments`;

    fetch(url,{
        method: "PATCH",
        body: JSON.stringify(data),
        headers:{
            "Content-Type" : "application/json"
        }
    }).then(response =>{
        if(response.ok){
            alert("댓글 수정이 완료 되었습니다.");
            window.location.reload();
        }
        else alert("댓글 수정 오류");
    })
}

function changeUpdateMode(event){
    const target = event.currentTarget.parentNode.parentNode;

    alert(target.classList.toString());

    const content = target.querySelector('#comment_content');

    const checkBtn = target.querySelector('#comment_ok_btn');
    const cancleBtn = target.querySelector('#comment_cancle_btn');

    const editBtn = target.querySelector('#comment_edit_btn');
    const deleteBtn = target.querySelector('#comment_delete_btn');

    content.removeAttribute('readonly');

    checkBtn.classList.toggle('invisible');
    cancleBtn.classList.toggle('invisible');

    editBtn.style.display = 'none';
    deleteBtn.style.display = 'none';

}

function changeNormalMode(event){
    const target = event.currentTarget.parentNode.parentNode;

    const checkBtn = target.querySelector('#comment_ok_btn');
    const cancleBtn = target.querySelector('#comment_cancle_btn');

    const editBtn = target.querySelector('#comment_edit_btn');
    const deleteBtn = target.querySelector('#comment_delete_btn');

    checkBtn.classList.toggle('invisible');
    cancleBtn.classList.toggle('invisible');

    editBtn.style.display = 'inline';
    deleteBtn.style.display = 'inline';
}
