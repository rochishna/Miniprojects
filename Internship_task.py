from bs4 import BeautifulSoup as bs
import pandas as pd
import urllib
from urllib.request import urlopen,Request
l=[]
kl=[]
s=[]
d=[]
p=input("Enter the product to  search reviews for")
reg_url='https://www.trustradius.com/reviews?q='+p
headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.3'}
m= Request(url=reg_url,headers=headers)
ph=urlopen(m).read()
ps=bs(ph,'html.parser')
con=ps.findAll("a",{"class":"search-from"})
con=len(con)-2
h=[]
klo=0
st=reg_url[36:len(reg_url)]
def func(reg_url):
    headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.3'}
    m= Request(url=reg_url,headers=headers)
    ph=urlopen(m).read()
    ps=bs(ph,'html.parser')
    con1=ps.findAll("article",{"class":"serp-result serp-layout serp-review"})
    for i in range(len(con1)):
        c=con1[i]
        d1=c.findAll("div",{"class":"review-date"})
        d.append(d1[0].text)
        p=c.findAll("div",{"class":"user-info"})
        k=p[0].text
        l.append(k)
        s1=c.findAll("div",{"class":"trust-score__score"})
        s.append(s1[0].text)
        kkk=c.findAll("h3",{"class":"h3 review-title"})
        h.append(kkk[0].text)
        pc=c.findAll("div",{"class":"serp-text"})
        kl.append(pc[0].text)
while(con!=0):
    reg_url="https://www.trustradius.com/reviews?f="+str(klo)+"&"+st
    con=con-1
    klo=klo+25
    func(reg_url)
position=pd.DataFrame(l)
date=pd.DataFrame(d)
score=pd.DataFrame(s)
review=pd.DataFrame(kl)
header=pd.DataFrame(h)
f=[date,header,position,score,review]
r=pd.concat(f,axis=1)
r.to_csv("review.csv")
