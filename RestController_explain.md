# RestController를 구성하기 위한 노력

RestController의 주용도는 Json 형태로 객체 데이터를 반환하는 것입니다. 

Controller의 상단에  @RestController 를 적용해서 기존에 뷰를 반환하던 Controller와 다르게 JSON 형태로 객체를 반환 해서 Spring boot와 다른 프레임워크(?)를 연결 시키는 매개체로 활용합니다.

아래의 코드들은 Postman 툴을 통해 정보 전달과 반환을 테스트 해보았습니다.

## **조회**

조회의 경우 GetMapping으로 URL의 변수를 활용해서 해당되는 숫자를 PK로 가지고 있는  객체 (Entity)를 데이터 베이스로 부터 가져와서, ResponseEntity.ok를 통해 해당 객체를 반환 해주었습니다.

```java
@GetMapping(value = "/read/{bno}") // URL에 변수를 사용해서 원하는 글만 조회 하게 했음

    public ResponseEntity<Optional<Board>> read(@PathVariable("bno") Long number)
    {

        return ResponseEntity.ok(boardService.read(number));

    }
```

## 등록

등록의 경우 정보 전달을 위해 PostMapping을 활용해서 JSON 파일로 저장할 글의 형태를 받아오면 

이를 save 기능으로 처리 했습니다. 만약 다수의 글을 저장하기 희망한다면 SaveAll을 활용해서 리스트형태의 글을 처리할수 있도록 설계했습니다.

```java
@PostMapping(value = "/saveAll") //만약 save할 JSON 파일이 배열 형태로 오게 된다면 , 이 방식으로 저장하도록 설정
    public void saveAll(@RequestBody List<BoardDTO> dto)
    {
        boardService.saveAll((ArrayList<BoardDTO>) dto);
    }
@PostMapping(value = "/save") //이제 POST 요청에서 JSON 파일을 받아서 저장소에 save 할 수 있음
    public void save(@RequestBody BoardDTO dto)
    {

        boardService.save(dto);
    }
```

여기서 JSON파일로 부터 정보를 받아오기 위해서는 @RequestBody 어노테이션이 필요하다는 것을 알게 되었습니다.

## 수정 , 삭제

수정 삭제의 경우는 위 등록 , 조회에서 필요에 따라 변수와 메소드만 변경한 형태로 설계했습니다.

```java
@PostMapping(value = "/modify") //이제 POST 요청에서 JSON 파일을 받아서 저장소에 modify 할 수 있음
    public void modify(@RequestBody BoardDTO dto)
    {
        boardService.modify(dto);
    }

    @GetMapping(value = "/delete/{id}") // id 받아서 삭제 하는 요청
    public void delete(@PathVariable("id") Long number)
    {
        boardService.delete(number);
    }
```