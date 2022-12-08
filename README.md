# Bible
Bible java version

제가 개발자로서 입문을 한지가 2004년도 그러니까 18년전이군요. 그때 한창 Java가 뭔지 Javascript 랑 같은거 아니냐? 뭐 이렇게 어려워? 해서 잠만 잤던 과목으로 기억합니다. 

선생님의 열정은 넘쳤지만 저의 피로도 넘쳐나서 잘 이해하지도 따라가지도 못했던 언어였습니다. 한창 개발자로서 두각을 드러내야 하는때에 비주얼베이직 과제와 엑셀만 잘했고 나머지 VisualStudio로 C#을 개발하라고 하셨을 때는 맨붕의 상태로 졸업을 어찌 했습니다. 몸으로 하는 거니 근로 장학금과 기적적으로 성적 장학금 한 번 받고 학교 생활을 마무리 하고 회사에 들어가서야 자바가 보이기 시작했습니다. 그때가 아마도 2010년 쯔음이었고 사수가 자바와 톰켓 C#에 능하였습니다. 그래서 그때를 토대로 오버라이딩 오버로드 개념을 익히고 객체 지향에 대해서는 이해 했지만 이렇게 클래스를 나눠서 작업을 하게 되는 것은 이번 프로젝트가 처음입니다. 물론 다른 여타 자바 프로젝트를 통해 객체지향형 자바 프로젝트는 많이 진행 했으나 그건 사수의 작품에 손을 대는 정도 였고, 제가 직접 객체지향 형태로 개발 한 건은 이번이 처음이라는 점입니다.

해당 개발은 Class - Model - View 형태로 개발하였으며, 개발된 파일은 아래와 같습니다.

### Bible.java ( View )
해당 파일에는 실행 부분만 구현 토록 하였습니다.

### Functions.java  ( Model )
해당 파일에는 성경 구절을 인용하기 위해서 입력된 구문에서 검색어 또는 번역버전, 책, 장, 시작절, 끝절을 구분하고 sqlite 파일과 연결 성경 본문을 검색하는 메서드, 웨스트 민스터 구절 , 성경 본문을 참조하도록 하였습니다.

### Valiables.java ( Class )
해당 파일에는 성경 변수에 사용할 sqlite를 연결할 connection, statement를 선언하고 검색어 또는 번역 버젼, 책, 장, 시작절, 끝절을 구분하여 변수에 담도록 선언 하였습니다.


실행방법
java Bible 창1:1-13
- 창세기 1장 1절에서 13절까지 출력

java Bible 창1 
- 창세기 1장 전체 출력

java Bible 동방 사람
- 성경에서 "동방 사람"을 검색 (검색어는 "로 감싸서 표기)

java Bible [각버전 두 글자] 창1
- kh : 현대어 창세기 1장 전체 출력
- kn : 새번역 창세기 1장 전체 출력
- ke : 쉬운 성경 창세기 1장 전체 출력
- ko : 개역 한글 국한문 창세기 1장 전체 출력
- kk : 킹제임스흠정역 창세기 1장 전체 출력
- ek : KJV 창세기 1장 전체 출력
- en : NewKJV 창세기 1장 전체 출력
- hb : Hebrew 창세기 1장 전체 출력
- gr : Greek 창세기 1장 전체 출력
