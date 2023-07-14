
import React,{Component} from 'react';
import "../css/Pagination.css";

class PagiNation extends Component{
  constructor(props){
    super(props)
  }
  pageClick=(page)=>{
      alert(page+"페이지 클릭!")
      this.props.setCurrentPage(page)
      //App가 props로 넘겨준 setCurrentPage메서드

      var pageClass=document.getElementsByClassName("page")
      for(var i=0; i<pageClass.length; i++){
        pageClass[i].style.fontWeight="normal";
        pageClass[i].style.backgroundColor="green";
      }
      
      document.getElementById("page"+page).style.fontWeight="bold";
      document.getElementById("page"+page).style.backgroundColor="gray";
  }

  prevPage=()=>{
    alert("이전페이지!")
    //App로 부터 넘겨받은 함수를 이용해서 페이지 번호를 감소시킨다.
    this.props.prevPage()
  }

  nextPage=()=>{
    alert("다음페이지!")
     //App로 부터 넘겨받은 함수를 이용해서 페이지 번호를 증가시킨다.
     this.props.nextPage()
  }

  render(){
    const {totalPosts,postsPerPage}=this.props
    let pageNumbers=[];

    //올림(10/3)->올림(3.333)->4
    for(let i=1; i<=Math.ceil(totalPosts/postsPerPage); i++){
        pageNumbers.push(i)
    }
    //pageNumbers=[1,2,3,4];
    //console.log(pageNumbers)
    const pageList=pageNumbers.map( 
        (page)=>(<span key={page} className="page"
        id={"page"+page}
        onClick={()=>this.pageClick(page)}>{page}</span>)
    )

    return(
      <div id="pagination">
          <span className="page">&lt;&lt;</span>
          <span className="page" onClick={this.prevPage}>&lt;</span>
          {pageList}
          <span className="page" onClick={this.nextPage}>&gt;</span>
          <span className="page">&gt;&gt;</span>
      </div>
    );
  }
}

export default PagiNation;