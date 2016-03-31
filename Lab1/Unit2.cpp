//---------------------------------------------------------------------------

#include <vcl.h>
#include <stdio.h>
#pragma hdrstop

#include "Unit2.h"
#include <dos.h>
//---------------------------------------------------------------------------
#pragma package(smart_init)
#pragma resource "*.dfm"
TForm2 *Form2;
struct date data;
struct time timp;
int i, x;

//---------------------------------------------------------------------------
__fastcall TForm2::TForm2(TComponent* Owner)
        : TForm(Owner)
{
Form2->Caption = "MIDPS 1-C";
Label1->Caption = "Data si ora curenta";
}
//---------------------------------------------------------------------------

void __fastcall TForm2::FormCreate(TObject *Sender)
{
        Edit1->Clear();
        Timer1->Enabled=true;
        Timer2->Enabled=false;
        Timer1->Interval=1000;
        Timer2->Interval=500;
        Button2->Enabled=false;
}
//---------------------------------------------------------------------------

void __fastcall TForm2::Button1Click(TObject *Sender)
{
        Button1->Enabled=false;
        Button2->Enabled=true;
        Timer2->Enabled=true;

	PaintBox1->Canvas->FloodFill(50,50,clBtnFace,fsBorder);
        PaintBox1->Canvas->Pen->Color=clBlack;
        for(i=0; i<200; i=i+10)
        {
                PaintBox1->Canvas->MoveTo(i,0);
                PaintBox1->Canvas->LineTo(i,225);
        }
        PaintBox1->Canvas->MoveTo(0,0);
        for(i=0;i<225; i=i+10)
        {
                PaintBox1->Canvas->MoveTo(0,i);
                PaintBox1->Canvas->LineTo(200,i);
        }

        PaintBox1->Canvas->MoveTo(0,100);
        PaintBox1->Canvas->Pen->Color=clRed;
	i = 0;
	x = 0;

}
//---------------------------------------------------------------------------

void __fastcall TForm2::Button2Click(TObject *Sender)
{
Button2->Enabled=false;
        Button1->Enabled=true;
        Timer2->Enabled=false;

}
//---------------------------------------------------------------------------

void __fastcall TForm2::Button3Click(TObject *Sender)
{
exit(1);
}
//---------------------------------------------------------------------------

void __fastcall TForm2::Timer1Timer(TObject *Sender)
{
                      char buffer[20];
        getdate(&data);
        gettime(&timp);
        sprintf(buffer,"%02d/%02d/%4d %2d:%02d:%02d", data.da_day, data.da_mon,
        data.da_year, timp.ti_hour, timp.ti_min, timp. ti_sec);
        Edit1->Text=(AnsiString)buffer;
}
//---------------------------------------------------------------------------

void __fastcall TForm2::Timer2Timer(TObject *Sender)
{
x = rand()%100;
        i = i+5;
        PaintBox1->Canvas->LineTo(i,x);

        Panel2->Height=x;


        if(i==200)
        {
	        Button1->Enabled=true;
	        Button2->Enabled=false;
	        Timer2->Enabled=false;
	        Timer2->Tag = 0;

	        i = 0;
	        x = 0;
        }


}
//---------------------------------------------------------------------------

