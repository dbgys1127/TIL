#include <stdio.h>

int main(void)
{
	/* ���� ����
	int age = 12;
	printf("%d\n", age);
	age = 13;
	printf("%d\n", age);
	*/
	//�ּ� ����
	/*printf("1\n");
	//printf("2\n");
	printf("3\n");*/

	//�Ǽ��� ������ ���� ����
	/*float f = 46.5;
	printf("%0.2f\n", f);
	double d = 44.28;
	printf("%.1lf\n", d);*/
	

	//����� ���� ����
	//int year = 2000;
	//printf("�¾ �⵵ : %d\n", year);
	//year = 2001;
	//printf("�¾ �⵵ : %d\n", year);

	/*const int year = 2000;
	printf("�¾ �⵵ : %d\n", year);
	year = 2001;*/

	//printf���
	//����
	/*int add = 3 + 7; // 10
	printf("3+7 = %d\n", add);//�������
	printf("%d x %d = %d\n", 30, 79, 30*79);// ���� ����=printf�� �����*/
	
	//scanf
	//Ű���� �Է��� �޾Ƽ� ����
	/*int input;
	printf("���� �Է��ϼ��� :");
	scanf_s("%d", &input); //input�� ������ ����
	printf("�Է°� : %d\n", input); //scan���� ������ ���� input���� ã�ƿ��ڴ�.*/
	/*int one, two, three;
	printf("3���� ������ �Է��ϼ��� :");
	scanf_s("%d %d %d", &one, &two, &three);
	printf("ù��° �Է°� : %d\n", one);
	printf("�ι�° �Է°� : %d\n", two);
	printf("����° �Է°� : %d\n", three);*///�ּ������� ctrl+k+c/ ������ ctrl+k+u

	//����(�ѱ���), ���ڿ�(�� ���� �̻��� ���� ����)
	/*char c = 'A';
	printf("%c\n", c);*/

	//char str[256];
	//scanf_s("%s", str, sizeof(str));
	//printf("%s\n", str);

	//�������� ������ ������ �Լ� (���� �ۼ�)
	// �̸�/ ����/������/Ű/���˸�

	char name[256];
	printf("�̸� ? ");
	scanf_s("%s", name, sizeof(name));
	
	int age;
	printf("��� ? ");
	scanf_s("%d", &age);
	

	float weight;
	printf("������ ? ");
	scanf_s("%f", &weight);
	

	double height;
	printf("Ű�� ���̾� ? ");
	scanf_s("%lf", &height);
	

	char what[256];
	printf("�� �˸� �ϰ� �˷ȴ�!!! ");
	scanf_s("%s", what, sizeof(what));

	const int year = 2021;
	const int month = 9;
	const int day = 6;
	char writer[256];
	printf("����� : ");
	scanf_s("%s", writer, sizeof(writer));




	printf("----------���� ������----------\n");
	printf("������ �̸� : %s\n", name);
	printf("������ ���� : �� %d��\n", age);
	printf("������ ü�� : �� %0.2f kg\n", weight);
	printf("������ ���� : %.3lf cm\n", height);
	printf("���� �˸�   : %s\n", what);
	printf("�ۼ���    %d��  %d��  %d��\n ", year, month, day);
	printf("�ۼ���      : %s\n",writer);

	return;
}