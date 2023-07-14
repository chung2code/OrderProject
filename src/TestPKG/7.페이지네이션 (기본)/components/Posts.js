
import React,{Component} from 'react';
import "../css/Posts.css";

class Posts extends Component{
  constructor(props){
    super(props)
  }
  render(){
    const result=this.props.posts.map(
        (data)=>(<li key={data.no}>{data.title}</li>)
    )
    return(
      <div id="posts">
          <ul>
          {result}
          </ul>
      </div>
    );
  }
}

export default Posts;