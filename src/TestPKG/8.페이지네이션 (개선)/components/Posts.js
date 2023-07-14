
import React,{Component} from 'react';
import "../css/Posts.css";
import Post from './Post.js';

class Posts extends Component{
  constructor(props){
    super(props)
  }
  render(){
    const result=this.props.posts.map(
        (data)=>(<Post key={data.no} 
          no={data.no} title={data.title}
          author={data.author} writeDate={data.writeDate}></Post>)
    )
        

    return(
      <div id="posts">
          <div id="post-header">
          <Post
          no="번호" title="제목"
          author="저자" writeDate="등록일"></Post>
          </div>
        
          <ul>
          {result}
          </ul>
      </div>
    );
  }
}

export default Posts;