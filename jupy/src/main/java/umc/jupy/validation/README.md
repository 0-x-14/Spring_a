## 어노테이션을 활용한 validation - 구조 설명
<br>

1. 클라이언트가 넘겨준 HTTP RequestBody의 데이터를 Controller가 받음
2. Controller가 해당 데이터를 RequestDTO로 변환
3. 해당 과정에서 RequestDTO의 **@ExistCategories 동작**
4. (해당하는 카테고리가 존재하지 않을 경우) **Validator에서** isValid의 false 값을 확인하고 **`ConstraintViolationException` 발생**
5. Controller에 @Valid가 있으므로 `ConstraintViolationException`이 *바로 전달되지 않음*
6. *@Valid 입장에서 검증이 실패한 것을 감지*하여 **`MethodArgumentNotValidException` 생성**
7. **최종적으로 ExceptionAdvice가 감지 후 Response 생성**<br><br>

![image](https://github.com/0-x-14/Spring_a/assets/81631374/783823d6-dd84-4a0f-ac18-b200ccb663ea)<br><br>
![image](https://github.com/0-x-14/Spring_a/assets/81631374/8d541b4d-e29a-4a5a-a1c9-02d3c0a591f9)
