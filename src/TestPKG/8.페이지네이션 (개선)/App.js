
import React,{Component} from 'react';

import Posts from './components/Posts.js';
import Pagination from './components/Pagination.js';

import "./App.css";

class App extends Component{
  constructor(props){
    super(props)
    this.state={
      posts:[
        {no:10,title:'title10',author:'kim',writeDate:'2021-12-01'},
        {no:9,title:'title9',author:'lee',writeDate:'2021-11-01'},
        {no:8,title:'title8',author:'park',writeDate:'2021-10-01'},
        {no:7,title:'title7',author:'choi',writeDate:'2021-09-01'},
        {no:6,title:'title6',author:'jeong',writeDate:'2021-08-01'},
        {no:5,title:'title5',author:'sin',writeDate:'2021-07-01'},
        {no:4,title:'title4',author:'lim',writeDate:'2021-06-01'},
        {no:3,title:'title3',author:'jang',writeDate:'2021-05-01'},
        {no:2,title:'title2',author:'bae',writeDate:'2021-04-01'},
        {no:1,title:'title1',author:'ann',writeDate:'2021-03-01'},
      ],
      currentPage:1,
      postsPerPage:3
    }
  }

  setCurrentPage=(page)=>{
    alert(page+"로 현재 페이지 변경!")
    this.setState({
      currentPage:page
    })
  }

  currentPosts=(totalPosts)=>{
    const {currentPage,postsPerPage}=this.state;
    //현재 페이지번호랑, 페이지당 글갯수를 이용해서
    //글배열에 추출할 글들을 고른다.
    //1페이지라면? 10,9,8 (배열 0번째부터 3개추출)
    //2페이지라면? 7,6,5  (배열 3번째부터 3개추출)
    //3페이지라면? 4,3,2  (배열 6번째부터 3개추출)
    //4페이지라면? 1
    //배열 내장메서드 slice를 써서 (어디부터, 어디까지)
    //배열.slice(시작위치,끝위치)
    const indexOfLast=currentPage*postsPerPage;
    const indexOfFirst=indexOfLast-postsPerPage;
    //1페이지: 3,0  -> slice(0,3)   - 0,1,2
    //2페이지: 6,3  -> slice(3,6)   - 3,4,5
    //3페이지: 9,6  -> slice(6,9)   - 6,7,8
    //4페이지: 12,9 -> slice(9,12)  - 9, ...
    const slicePosts=totalPosts.slice(indexOfFirst,indexOfLast)
    //totalPosts.slice(indexOfFirst,indexOfLast)
    //totalPosts배열에서,시작점:indexOfFirst,끝점:indexOfLast 부분 추출
    return slicePosts;
    //페이지 번호에 해당하는 갯수만큼만 자른 글이 return
  }

  prevPage=()=>{
    alert("이전페이지!(App)")
    //App로 부터 넘겨받은 함수를 이용해서 페이지 번호를 감소시킨다.
    const {currentPage}=this.state//비구조화할당
    if(currentPage===1){
      alert("이동불가!")
    }else{
      this.setState({
        currentPage:currentPage-1
      })
    }
  }

  nextPage=()=>{
    alert("다음페이지!(App)")
     //App로 부터 넘겨받은 함수를 이용해서 페이지 번호를 증가시킨다.
     const {currentPage,posts,postsPerPage}=this.state
     let lastPage=Math.ceil(posts.length/postsPerPage)
    if(currentPage===lastPage){
      alert("이동불가!")
    }else{
      this.setState({
        currentPage:currentPage+1
      })
    }
  }

  render(){
    const {posts,postsPerPage}=this.state
    return(
      <div id="App">
          <Posts posts={this.currentPosts(posts)}></Posts>
        
        <div id="pagination-wrap">
        <Pagination postsPerPage={postsPerPage}
          totalPosts={posts.length} setCurrentPage={this.setCurrentPage}
          prevPage={this.prevPage} nextPage={this.nextPage}></Pagination>
        </div>
          
      </div>
    );
  }
}

export default App;