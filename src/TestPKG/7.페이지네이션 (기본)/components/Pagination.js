
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
        onClick={()=>this.pageClick(page)}>{page}</span>)
    )

    return(
      <div id="pagination">
          <span className="page" onClick={this.prevPage}>&lt;</span>
          {pageList}
          <span className="page" onClick={this.nextPage}>&gt;</span>
      </div>
    );
  }
}

export default PagiNation;