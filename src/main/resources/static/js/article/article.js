function createArticle(){
    const nickname = document.querySelector("#new_article_author").value;
    const title = document.querySelector("#new_article_title").value;
    const content = document.querySelector("#new_article_content").value;

    const data = {
        author: nickname,
        title: title,
        content: content
    };

    console.log(data);

    const url = '/api/articles/new';
    fetch(url, {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(response => {
        if(response.ok) {
            alert("게시글이 등록 되었습니다.");
            window.location.reload();
        }
        else {
            alert("게시글 등록 실패");
        }
    });
}

function updateArticle(){
    const loginUser = document.querySelector('#hidden_user_nickname').value;
    const author = document.querySelector('#update_article_author').value;
    const title = document.querySelector('#update_article_title').value;
    const content = document.querySelector('#update_article_content').value;

    if(loginUser != author){
        alert("게시글 수정은 작성자만 가능합니다.");
        return;
    }
    if(title == "") {
        alert("제목을 입력하세요.");
        return;
    }

    const data = {
        author: author,
        title: title,
        content: content
    }

    const articleId = document.querySelector('#hidden_article_id').value;
    const url = `/api/articles/${articleId}/update`;

    fetch(url, {
        method: "PATCH",
        body: JSON.stringify(data),
        headers:{
            "Content-Type": "application/json"
        }
    }).then(response => {
        if(response.ok){
            alert("수정이 완료 되었습니다.");
            window.location.reload();
        }
        else alert("게시글 수정 오류");
    });
}

function deleteArticle(){
    if(!confirm("게시글을 삭제 하시겠습니까 ?")) return;

    const articleId = document.querySelector('#hidden_article_id').value;
    const url = `/api/articles/${articleId}/delete`;

    fetch(url,{
        method: "DELETE"
    }).then(response =>{
        if(response.ok) {
           alert("삭제가 완료 되었습니다.");
           window.location.href = "/articles";
        }
        else alert("게시글 삭제 오류");
    })
}

function viewArticle(event){
    const target = event.currentTarget;
    const articleId = target.querySelector("#article_id").value;

    window.location.href = "/articles/" + articleId;
}
