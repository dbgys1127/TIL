
# What Tag?
태그에 대해서 공부하기전, 태그는 무엇일까? 먼저 알아보자.   
영어사전에 나와있는 정의는 '꼬리표'가 있다. 이 말을 HTML에서 적용   
하면, 태그란, 웹문서에 어떤 표시를 해주는 것이라고 풀이할 수 있다.  
표시할 수 있는 것은 태그 표시대상의 크기, 글자색, 모양 등을 변경하거나, 
링크, 네모 박스 등을 표현한다.

# Frequent Tag
HTML에는 다양한 태그들이 있지만, 그 중 Web에서 가장 많이 쓰이는     
태그를 알아보자!

## 1. `<strong>`, `<i>`, `<u>` tag 
- 먼저 `<strong>` 태그는 글자를 굵게 표시해준다.
    ```
    <strong>What Tag?</strong>
    ```
    <strong>What Tag?</strong>  
<br>
- `<i>` 태그는 글자를 기울여서 표시해준다.
    ```
    <i>What Tag?</i>
    ```
    <i>What Tag?</i>  
<br>
- `<u>` 태그는 글자에 밑줄을 표시해준다.
    ```
    <u>What Tag?</u>
    ```
    <u>What Tag?</u>  
<br>

## 2. `<h1>`~`<h6>`
- 이 태그는 글자의 크기가 미리정해진 값에 따라 표시된다.
    ```
    <h1>What Tag?</h1>
    <h2>What Tag?</h2>
    <h3>What Tag?</h3>
    <h4>What Tag?</h4>
    <h5>What Tag?</h5>
    <h6>What Tag?</h6>
    ```
    <h1>What Tag?</h1>
    <h2>What Tag?</h2>
    <h3>What Tag?</h3>
    <h4>What Tag?</h4>
    <h5>What Tag?</h5>
    <h6>What Tag?</h6>
<br>    

- 이때 이 태그는 자동으로 한칸을 띄어준다.
- 글자 크기를 조정하는 태그로 `<span>` 태그도 있다.
    ```
    <span style="font-size:24px">What Tag?</span>
    ```
    <span style="font-size:24px">What Tag?</span> 
<br>
- 하지만, 키워드 검색시, span은 글자 스타일을 바꾼 것이고,<br> h는 제목을 지정한 것이기 때문에, 검색엔진의 선택을 받을 확률이 높다.

## 3. `<br>`, `<p>`
- `<br>` 태그는 띄어쓰기를 해주는 태그다.
    ```
    Hello! nice weather today.<br>Do you have any plan after class?
    ```
    Hello! nice weather today.<br>Do you have any plan after class? 
<br>
- `<p>` 태그는 태그로 감싼 부분을 문단으로 구분해준다.
    ```
    This is Kim's opinion <p>Russia attacked Ukaine at last night.<br>This is inhumance incident.<br>We must fight with Ukraine!</p> Thank you! Kim! And I agree with you
    ```
    This is Kim's opinion <p>Russia attacked Ukaine at last night.<br>This is inhumance incident.<br>We must fight with Ukraine!</p>Thank you! Kim! And I agree with you
<br>

- 언뜻 보면, 둘은 매우 닮은 것 같지만, `<br>` 태그는 </>가 필요없다.
- 또한,`<p>` 태그는 정해진 값만큼, `<p>` 태그 전후와 띄어주지만, `<br>` 태그는 여러번 줄바꿈을 할 수 있다.

## 4. `<a>`
- 지금까지 태그를 통해서는 고립된 문서가 되겠지만, `<a>`를 통해, 다른 문서와 연결<br>되게 할 수 있다.
    ```
    <a href="https://www.w3schools.com/tags/tag_a.asp" target="_blank" title="what is a tag in html">`<a>`tag</a>
    ```
    <a href="https://www.w3schools.com/tags/tag_a.asp" target="_blank" title="what is a tag in html">`<a>`tag</a>

- href 뒤에는 링크
- target을 _blank로 설정하면, 새탭에 링크열기
- title은 링크의 간략한 설명을 추가할 수 있다.

## 5. `<img>`
- `<img>` 태그를 이용하면, 이미지를 삽입할 수 있다.
    ```
    <img src="code/web/HTML/covid.jpg" width=30%>
    ```
    <img src="image/covid.jpg" width=30%>

- 이때 src는 source에 줄임말로 경로를 기입해야한다.
- width는 %나, 숫자로 기입하여, 이미지 크기를 정한다.

## 6. `<iframe>`
- 이 태그는 영상을 첨부할 수 있다.
    ```
    <iframe width="560" height="315" src="https://www.youtube.com/embed/tZooW6PritE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
    ```
    <iframe width="560" height="315" src="https://www.youtube.com/embed/tZooW6PritE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

## 7. `<li>`태그와 `<ul>` vs `<ol>`
- `<li>`는 목록화 태그로 목차나 목록을 점표시와 함께 표현한다.
    ```
    <li>egoing</li>
    <li>dbgys1127</li>
    <li>youtube</li>
    ```
    <li>egoing</li>
    <li>dbgys1127</li>
    <li>youtube</li><br>
- `<ul>`은 li의 부모 태그로 목록안에 하위 목록이 구별될 수 있게 해준다.
    ```
    <ul>
    <li>1.HTML</li>
    <ul>
        <li>egoing</li>
        <li>dbgys1127</li>
        <li>youtube</li>
    </ul>
    <li>2.CSS</li>
    <li>3.JavaScript</li>
    </ul>
    ```
    <ul>
        <li>1.HTML</li>
        <ul>
            <li>egoing</li>
            <li>dbgys1127</li>
            <li>youtube</li>
        </ul>
        <li>2.CSS</li>
        <li>3.JavaScript</li>
    </ul><br>

- `<ol>`는 자동으로 순서를 기입해준다. 목록이 삭제, 추가 되도 자동반영이된다.
    ```
    <ol>
    <li>HTML</li>
    <li>CSS</li>
    <li>JavaScript</li>
    </ol>
    ```
    <ol>
        <li>HTML</li>
        <li>CSS</li>
        <li>JavaScript</li>
    </ol>

## 8. `<div>` 태그와 `<span>`
- div 태그는 한줄을 차지한다.
- span 태그는 컨텐츠 크기만큼 공간을 차지한다.

## 9. `<input>`태그와 `<textarea>`
- input : 텍스트 박스, 입력할 수 있는 박스
    - type ="text" 는 사용자 입력을 받는 박스 생성
    - type = "password"는 비밀번호 입력할 수 있게, 사용자가 입력하는 내용이 가려진다.
    - type = "checkbox"는 체크 박스를 만들 수 있다.
    - type = "radio"는 체크박스와 다르게 여러개 중 하나만 선택가능하다. 체크 박스는 여러개 선택 가능하다. `이때 옵션들을 name="그룹명"으로 같은 그룹에 묶어야 둘중 하나 선택이 적용된다.`
- textarea : 줄바꿈이 되는 입력폼이다.
- button
## 그외 참고할 만한 것
<a href="https://heropy.blog/2019/05/26/html-elements/">한눈에 보는 HTML 요소</a>
<br>
W3C: <a href="https://www.w3schools.com/html/html_exercises.asp" target="_blank">HTML 연습</a>