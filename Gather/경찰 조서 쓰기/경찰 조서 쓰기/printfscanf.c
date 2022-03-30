#include <stdio.h>

int main(void)
{
	/* 변수 개념
	int age = 12;
	printf("%d\n", age);
	age = 13;
	printf("%d\n", age);
	*/
	//주석 개념
	/*printf("1\n");
	//printf("2\n");
	printf("3\n");*/

	//실수형 변수에 대한 예제
	/*float f = 46.5;
	printf("%0.2f\n", f);
	double d = 44.28;
	printf("%.1lf\n", d);*/
	

	//상수에 대한 예제
	//int year = 2000;
	//printf("태어난 년도 : %d\n", year);
	//year = 2001;
	//printf("태어난 년도 : %d\n", year);

	/*const int year = 2000;
	printf("태어난 년도 : %d\n", year);
	year = 2001;*/

	//printf기능
	//연산
	/*int add = 3 + 7; // 10
	printf("3+7 = %d\n", add);//변수사용
	printf("%d x %d = %d\n", 30, 79, 30*79);// 변수 없이=printf의 계산기능*/
	
	//scanf
	//키보드 입력을 받아서 저장
	/*int input;
	printf("값을 입력하세요 :");
	scanf_s("%d", &input); //input은 저장할 공간
	printf("입력값 : %d\n", input); //scan에서 저장한 값을 input에서 찾아오겠다.*/
	/*int one, two, three;
	printf("3개의 정수를 입력하세요 :");
	scanf_s("%d %d %d", &one, &two, &three);
	printf("첫번째 입력값 : %d\n", one);
	printf("두번째 입력값 : %d\n", two);
	printf("세번째 입력값 : %d\n", three);*///주석단축기는 ctrl+k+c/ 해제는 ctrl+k+u

	//문자(한글자), 문자열(한 글자 이상의 여러 글자)
	/*char c = 'A';
	printf("%c\n", c);*/

	//char str[256];
	//scanf_s("%s", str, sizeof(str));
	//printf("%s\n", str);

	//경찰관이 범죄자 정보를 입수 (조서 작성)
	// 이름/ 나이/몸무게/키/범죄명

	char name[256];
	printf("이름 ? ");
	scanf_s("%s", name, sizeof(name));
	
	int age;
	printf("몇살 ? ");
	scanf_s("%d", &age);
	

	float weight;
	printf("몸무게 ? ");
	scanf_s("%f", &weight);
	

	double height;
	printf("키는 몇이야 ? ");
	scanf_s("%lf", &height);
	

	char what[256];
	printf("니 죄를 니가 알렸다!!! ");
	scanf_s("%s", what, sizeof(what));

	const int year = 2021;
	const int month = 9;
	const int day = 6;
	char writer[256];
	printf("수사관 : ");
	scanf_s("%s", writer, sizeof(writer));




	printf("----------범죄 진술서----------\n");
	printf("범죄자 이름 : %s\n", name);
	printf("범죄자 나이 : 만 %d세\n", age);
	printf("범죄자 체중 : 약 %0.2f kg\n", weight);
	printf("범죄자 신장 : %.3lf cm\n", height);
	printf("범죄 죄목   : %s\n", what);
	printf("작성일    %d년  %d월  %d일\n ", year, month, day);
	printf("작성자      : %s\n",writer);

	return;
}