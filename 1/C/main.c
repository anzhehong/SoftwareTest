# include "Predict.c"

int main(int argc, char const *argv[])
{
	void showErrorMsg();

	int year, month, day;
	printf("请输入年份\n");

	while(!scanf("%d",&year) || year < 0)
		showErrorMsg();

	printf("请输入月份\n");

	while(!scanf("%d",&month) || month > 12)
		showErrorMsg();

	printf("请输入日期\n");

	while(!scanf("%d",&day) || day > 31)
		showErrorMsg();

	Predict(year, month, day);

	return 0;
}

void showErrorMsg() 
{
	fflush(stdin);
	printf("Invalid Input...Please input a valid number again!\n");
}