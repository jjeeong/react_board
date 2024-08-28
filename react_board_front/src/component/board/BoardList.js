import { useEffect, useState } from "react";
import "./board.css";
import axios from "axios";
import { Link } from "react-router-dom";

const BoardList = () => {
  const [boardList, setBoardList] = useState([]);
  /*
  useEffect(()=>{},[])
  useEffect 혹은 컴포넌트가 렌더링이 일어나면 첫번째 매개변수에 있는 함수를 실행되는 함수
  함수가 다시 동작하는 조건!
  두번째 매개변수에 있는 배열에 state를 넣어두면, 해당 state가 변경되면 한번씩 다시 돌아감
  */

  useEffect(() => {
    axios
      .get("http://192.168.10.53:9999/board/list")
      .then((res) => {
        console.log(res);
        setBoardList(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  return (
    <div className="board-list-wrap">
      <h3>게시글 목록</h3>
      <Link to="/write">글쓰기</Link>
      <div className="board-list">
        <table>
          <thead>
            <tr>
              <th style={{ width: "10%" }}>글번호</th>
              <th style={{ width: "50%" }}>제목</th>
              <th style={{ width: "15%" }}>작성자</th>
              <th style={{ width: "25%" }}>작성일</th>
            </tr>
          </thead>
          <tbody>
            {boardList.map((board, index) => {
              return (
                <tr key={"board" + index}>
                  <td>{board.boardNo}</td>
                  <td>
                    <Link to={"/view/" + board.boardNo}>
                      {board.boardTitle}
                    </Link>
                  </td>
                  <td>{board.boardWriter}</td>
                  <td>{board.boardDate}</td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
};
export default BoardList;
