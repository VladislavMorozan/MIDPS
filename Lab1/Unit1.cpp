//---------------------------------------------------------------------------

#include <vcl.h>
#include <stdio.h>
#pragma hdrstop

#include "Unit1.h"
#include "dos.h"
//---------------------------------------------------------------------------
#pragma package(smart_init)
#pragma resource "*.dfm"
TForm1 *Form1;
unsigned int D=0;
unsigned int S=0;
unsigned int M=0;
struct date data;
struct time timp;


//---------------------------------------------------------------------------
__fastcall TForm1::TForm1(TComponent* Owner)
        : TForm(Owner)
{

Form1->Caption = "MIDPS 1-B";
Label1->Caption = "Realizarea unui cronometru in C++ Builder";
Label2->Caption = "CRONOMETRU C++ Builder";
Edit1->Clear();
        Timer1->Enabled=true;
        Timer2->Enabled=false;
        Timer1->Interval=1000;
        Timer2->Interval=100;
}
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
void __fastcall TForm1::Button2Click(TObject *Sender)
{
      
      Timer2->Enabled = false;
}
//---------------------------------------------------------------------------
void __fastcall TForm1::Button1Click(TObject *Sender)
{

      Timer2->Enabled = true;
}
//---------------------------------------------------------------------------
void __fastcall TForm1::Button3Click(TObject *Sender)
{
    D=0;
    S=0;
    M=0;
    Edit2->Text = IntToStr(M) + " min : " + IntToStr(S) + " sec : " + IntToStr(D) + " zec";

}
//---------------------------------------------------------------------------
void __fastcall TForm1::Timer1Timer(TObject *Sender)
{

      char buffer[20];
        getdate(&data);
        gettime(&timp);
        sprintf(buffer,"%02d/%02d/%4d %2d:%02d:%02d", data.da_day, data.da_mon,
        data.da_year, timp.ti_hour, timp.ti_min, timp. ti_sec);
        Edit1->Text=(AnsiString)buffer;

}
//---------------------------------------------------------------------------
void __fastcall TForm1::Timer2Timer(TObject *Sender)
{
           D+=1;
         if(D==100)
         {
         S+=1;
         D=0;
         }
         if(S==60)
         {
         M+=1;
         S=0;
         }
         Edit2->Text = IntToStr(M) + " min : " + IntToStr(S) + " sec : " + IntToStr(D) + " zec";

}
//---------------------------------------------------------------------------
void __fastcall TForm1::Button4Click(TObject *Sender)
{
     exit(1);
}
//---------------------------------------------------------------------------
