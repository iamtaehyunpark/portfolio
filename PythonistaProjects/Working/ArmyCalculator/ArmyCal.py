import ui
from datetime import *


now = date.today()
global start

def typed(sender):
	v = sender.superview
	
	start = v['datep'].date.date()
	end = start+timedelta(546)
	remaining = (end - now).days
	after = (now - start).days
	percent = ((now-start).days/546)*100
	monthPassed = (now.year - start.year) * 12 + now.month - start.month
	
	label = v['enddate']
	label1 = v['outputdate']
	label2 = v['outputpercent']
	
	label.text = f'  당신의 전역일은\n  {end.year}년 {end.month}월 {end.day}일 입니다\n  복무 {monthPassed}달 차 입니다'
	label1.text = str(remaining)
	label2.text = str(round(percent,2))+'%'
	
	v['slider1'].value = percent/100
	


v = ui.load_view()
v.present('sheet')