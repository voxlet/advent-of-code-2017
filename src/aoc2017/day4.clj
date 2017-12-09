(ns aoc2017.day4
  (:require [clojure.string :as string]))

(def input
  "bdwdjjo avricm cjbmj ran lmfsom ivsof\nmxonybc fndyzzi gmdp gdfyoi inrvhr kpuueel wdpga vkq\nbneh ylltsc vhryov lsd hmruxy ebnh pdln vdprrky\nfumay zbccai qymavw zwoove hqpd rcxyvy\nbcuo khhkkro mpt dxrebym qwum zqp lhmbma esmr qiyomu\nqjs giedut mzsubkn rcbugk voxk yrlp rqxfvz kspz vxg zskp\nsrceh xdwao reshc shecr\ndcao isz wwse bbdgn ewsw qkze pwu\nlbnvl lviftmr zqiv iadanl fdhrldn dlaani lxy dhfndrl fkoukx\nraovmz pdysjsw hqps orsyqw rrwnzcz vrzoam jjljt\nwgt gzi icpwp qeefgbe msadakj jbbrma sbj dufuujx zex\ncfzx bvyu eswr hafcfy klw bgnhynv qrf aop\nrzlq atrzcpb hpl pajjw cdxep ean aptzcrb rzcbapt\nxogpf ucc nsukoz umtfbw xfvth ozusnk fopxg ubp iflb\nxot nqcdyu kpwix szo cyxv hpmp hwtrc zso nyuqdc aha\nmkzf cat tkjprc izxdggf obspan lmlbg bsyspf twox\nlfmfrd ooclx tcl clt\ndxvnyd nxwojj arutn eyqocj swzao tmh juvpezm\nteu eman rlmdmk xkbodv fvrcm zorgy wmwe\nhmo fdayx duciqf cgt duciqf\nimjnv vfmsha cyrusow xjswoq nclrmjy sjxowq ynjrcml\nrwbsay alsi bmzpvw ozq aduui nihwx glwdiz ixmkgfx\nvtjzc ntkh zekj qrbkjhn zekj lyfnbg\nafaig jqhli oie lhwyduh kqfnraz nfrzaqk mayfg iljqh\ninb zum zmu dnl zjxg vrdziq ypdnsvt\nuhbzmre mpdxm alkbmsq aopjmkl mqxenry ayvkrf zxvs qkfqva\nfimjr ccv cnug crdsv\nbqyve lhxdj ydu qbyve vihwjr vyodhc\nvmng dyttyf noagpji tdtyfy ewiest ogg\nkgscfj klmsv vmksl vmlks\nqlvh veo wruft wtm fbrlvjr evo wvwmny dhp bvrlrfj lvt vgzuyyw\nmxuro orxmu tivu tjdq ojjvju cdd\nkjexme gxbysxp yxrum hinrklv fxehytd qkt tqk umryx nim\nkywnux wab tzrft dsaz jgwuw dubarmi fle wjguvr umjp uzncwj mzz\nqokwh zrda xywufk tbxhhj eejqaoa hwoqk zer hwt hbjxth xyf hmh\neregs qdx tdequa agrlrg mwwpba qjie yrjvhr txujk\niyot fxwdcb zvwfv vfzwv wvkw ncwbr wdejrr ltcdza\nwaix eza znmonya ldfghws ialwfvc dey ubsz uhbnh svgekg nonzyam\nbryz tfbqn xznfmw xiplgww wwxigpl jxzcgxl rzyb\ncqvl rrcoqxs staeuqr hzzow cwv tsvol dio coc ddavii uuojy\ntxbn qvkkyh gbqnjtq ndpkqr srt bkpqfmm ytycev ypcv bpqmmfk\nuqkjmul dour zgq ztango yrrjhrg ufxnmuw\nekxbcv vkxbec xbcevk jiq bar\nwczff qdu cwffz hhk wlvyg\nzjlconc osgsro dajzo hqih ehml\nhnio shccluw cpu ivaby tormn vkef abv vkef ivaby\nxgbdeso xiizs omqwy sbtnnt khago evviclw xyu dtvg wsyxfuc humewp\ncnzu bia vdyqrf wwb qveum hmh ouupgc owli\npjpmfxa dvd lxgh ndy gwph oebfkqv vtlxdg efl ekj dyn\nmvan nmdkc ucyshia mavn ecst poo\noybm pjwm bmyo wovgu xykziaq obmy eiirhqd\nxkvomx yxvv oxxpth elh vxvy lhe ycn\nokxglw gmaangx gnxaamg yduzrr nzwxtnd rcxcu xjjvno yat cin gaxnamg yss\noicgs rrol zvnbna rrol\nabb edpnxuo peoudxn bab ceay\nncpkfz gvwunb fckpzn caafx pkcfzn tsfl\nfnrt ymenkpq wodubcm niv nvi ziluu cuowbdm zocg pdakwt mlzxkex nuxqclo\nuouxcgl stgua otadr ideannq wizxunv iqsdpj mxddt ldst ucxogul\nrbrwyhk wqoz zqwo ikwgexl atpu iza\nsmo yolp pcahlu muljxkq cbkljmz zlbcmkj zvbmgz eaiv ncv zplifm yplo\nocutdhz zmnaap llgv llzpl loavju guzkfq saay rxyhng cwxzx lcv anrnzs\netyzx tcm upxrtvd imyoiu rdpj fed dmm\ngonqa szteh szteh razdqh phyff upf knfqfaf knfqfaf fpsgl kakag\nmcju mixskop isrwat lcr nfyi lcr aaevr nfyi pqrbk gnful\nxfmr fkmnq fbnhd mxrf litniid xbae frxm zcenf\nyuh lzojtj rqsh hyu\nvbjgql yeshsuv lokt efqota wpwjfu ykyq rxc fxxh ycqfkk gndts vdf\nwnylmr kkuruxm azr xukrkum dohkwx dmdb\nbjiyrwf dvf fdv vdf gnokekr\njsaq hcww iayqtu llv gdpxdrd hwlo nosjit wpm lcab fcgwr\nfxjp bys nnf xzllckh bys hvojw zcwtgwz wye ccyvjv\ngrafa hbb ghk wkdpsf ufa uoqmysd\nyvacf kssbff iovrm mvrio cfbpb avh zzje\ngqd qmsen wkvrfz vhtsa zrwfkv gul zkvwrf\nhrbi svaogb aogsvb bgrk hibr jbtkr\nljl ryc mrewrge yky\nfcqyymt emk qcmyytf mcfvusb luy qany cbsvumf\noknt mcozuc ccmuoz uoccmz\nuziil xobutwf acnof iqgwl diso\nsekq fxbtsuv ddnnqg rnemlt dngnqd hhgjfus stxvubf\nlajcp qgiw fyz blrlcd pviwv buh wnkk\nwolqfk nvpapfc rwcqxfz xobno yzjfz irpj wolqfk wbnwjt\nvmabj noiljne hhqf holxkbk swwzx ylgj lnmxy lqodhk abjvm bmsrf\nbpnp yrz pjepxxs jlmhuy vihlx zacm inuazhc xsxjepp\ntryl kryh eonvaad ucevssk umkxg lqej nswopjj svkeucs bmh stosxxz\ncfdwd dmfdrvm ibuhsz nwtgmb pjt dmfdrvm cqdcm fzjjz afa ibuhsz\nerwp abn jwx ynmkkj rhgg abn epd atqhs rst rhgg\njtnp cegdsoy gfuvfbg gdmn ahlsc\njgrp diu jrgp onjnml nojmnl vxockc\nlakqyuw khq dcpiwt ykwlqua hkq plklx ujbckec hjcvur jnp pvyf\nusuvoo jkih ylafyy yhio jureyj\nuazisdf cnwlfnf ewodatr woaddkd wbla qmn atdrowe\nbnyepaa ntqh xppe ydtsw ppex\nyewjwsp jxylmtk ijese ewry ijese kbja nfml zeuwcsh juimz\nqbvmf nca zsfreo uurgaiz twe fbqmv ncwi etdcsk atowfp\njeotslx kgdpzp wxlcww pdd dcn ddp\nmacllv ldl kyluine lbt hbxbr wxcaspp ezwvc qxkeu\nivg gxv zsf ucr uff yrz\ntdlwbny bqlrlz tbynwdl lwtbdny\ntnekq pdaievs ttwpfh xfm fcaa\nzqqhl zbf fbz uqrv bfz ffwavhk foccg\nvcw ebqdd cwv eddbq nrmq\nhpiusz sizphu xzq sgyehk wgagkv hsygek\nvagkxa iou frqdnnr ipcg uxvh vvh eskf katgpiq aqktigp gzvseyi\nxkwgd kzfxk pgdy fmtvq ngf rshx zti pamviob ely knz\nhwo rteohu qzwoe rotuhe wzb\nbsqgg tid dti gtats dit\nsjtux djwxv dljwjq xwvjd xnqfvx veqdrtl uxtsj nnkjn wnhilaf unirrp\nfruuqjk gtote gooklg bzwhim zfnccmm ezipnf cxwdxa wfu fdca\nzcyxb byzxc cxbyz pgcqco ivlxz\nwrjh zfdinsf ihw xwosiah hdg xpiabno bilyy azdeczg javuwa\nrinlv dcpt qhencba mmb njxw gadc\nqwcpua qzyzt cxjsgh kumh byiimas qhsgf qytzz rqqruwp ismyiba xydcxz rwkscqa\nxbzefi hltca ibzxfe fkx xizbfe wvaynts\noyuce vzk ouxvj gfh efgbv ubc nyb bxnbhd mtwboe whksy ovmrt\nljrebp tacn bpjler utphw wmfw rcnha\ndrdnic eyodes rcnidd yseeod\numxmsf kfroz ukhjin awpnnnu ooyyohh tuv rafano jze\nbakz lfzpjyg gfkqcgn kzh zwpvk gqfngck\njpaony ojpnya hmro xaaz tovary aaxz iel pbg\nswvbgc bbhjp yvrcddd rhj clfu eao afrkegn qvvb yvcx nxjmdo rcvtx\nconbjy jeqtri wvujt jeqtri rkhllgw tsdt zowreo qxr qbpragn kuzmplw wvujt\njrpxyp hchljy rkowqb eeaf ltllebb gtksrwx iazx vnsfmc zzrxw hlcjyh\npiehb cjdzt eqn kuje rls oaewoz lrqwt lcrrq\nhdjowxv uknhlv hluknv pokxg\ntxiqxfr fyyp pyyf xfxtrqi tvm rtvby cfx trx nwrf kqrxtat alwot\nwdaadr stexpow ardawd uejqxc\nwwgwjel wwgwjel mtjt wwgwjel\nmczx uua lgceb dqru vkcea tcet ruz\njkt yroojr qdrtdu wze ovwz fdmqnr xxsyfd kchytwl hctlkwy gyd\neif irnrce iamhxgh bmis uxye azrwdi sznv yuowb vdlqqxu\ndxdjyj hngqwzs yhwku qhsctfe rhbc rchb tqhcfse\nfxyxnzs qtxevin rvtxtc iqnxtve\nzgbpk mwzxx bgpkz wkpkn\nrjiym iub lcyw agbtlb bzhx osv rbtf\nemmyu uoflio tinih skpqaj rbor gezbhhv ine mij qlqte uuj ycns\nowmwc uhxv pyho ftjh jzsg blqn bszyo bob trbycy mkru\nmwgz bbqsmpp fgzs bihhg bbn pjxxexs qrqmt htsxfwo qltqp vqqaxi\nlpr wcvy sxjqq ltd rftdgv pdnog ymu\nqhcos shuy icdhucu lrikh rwslv yxbgibl rcomhn wakirz\ncivdmee owlzocl vedecim rogmjnn pix pohcmk dsjm yworm\nvzdpxp lvt inufv yofqt omm qfoty qrlseqy amkt kjcvg vgkjc\nhuhq quhh levzsws sjuun ofgqr cjhp nfxbbft rnt wtbd tbzab\ntjftkx xpfcv hvftvhw lpypbjg batrn fhwhtvv uthl arbtn brb sthv\nogr uyuxdco bpjgir edztxv sxtgu jzfmx ihnauz zwegqkr kvkw\nmhxthf pervvn gshy jig ezjteq ckkcpy gww\ntiljyki rpe prcojy tjkylii moxu\npjsdqc lgqydfd lohck emrtejw axwmo wuuv rfi qzyncmw gjijdfb bljfd xrs\nywjab gynzi relf kziy xmsby izyk ocwoho kqnyh bwayj\nbhjlz uonz jhmzuq eiajoos zjnbj tomj bmyv hjlbz fgw jjbnz\nkszz xzw xzw prtznyb\nghzk vxhwt thxwv slwpayp qxegmi dawdwo kgzh\nibpcvuf wnuwxu sbf jsj bfjynl cdp jbylnf\nepaxr vfhf hvff azepadz pwf sbo pgfzya hslyo rqqj rmklw hwtta\nyyolko pwbvxvg xdwl yfje hftep kzzsr kho jeyf yvslxpw kfyv\nxmk juyjxy eqno mdwklum reg dgn cirh wmxfyj bnxlgo dlobk\noyv gshqyot jgcqe dsf gyohqst gqgeojo egoogjq dmqpyp\nsypianq yss lmhu ulmh itilh ndkda lhiit\nqbxxl bxxql ikald nfap qixwbqq\njtqhqty ljysnl nwoj toa bmmyj pal\nahktew sxody nkvsf pbxyt baws wgwfwej bevgzm jus hcvajfy kzrb jwgwewf\njzsb szbj ujngwf nfuuf lfiuxdu uufnf orsy\nvgo hto isstyul gau wsmxoqw\nuxw itwf epaw hec wape hemol rpwyosc xzxmrll eetz zui kagca\nmjncux muv rygdeis rygdeis\nqgkqjvf iprzibd fkvqqgj llcrl vbh vlf lllrc zwrunt\ndslsa wvoex eqbwj tjem gbx ayn xcan fnacl xggxon gnwjlh\nyzosv hcxjiz yvon gcgd\nbixpny ecln sda eymt bjiwk\nrlcad lrdca adoqfzs rgty mds pwb kmwj\nwkai pmryffq rrdmodc wgyx taz yxwg nkap\nauynzwc vzg uapdv qkrh\nldmuysp oyu kpn ejbl mfifa bzs hwyn brlw qpzqx uyilao ysdumpl\nczoxoj pwnultl wezolbw lyk aonesgb\nnqy nhb nle yycp lgtbo ojf dytwyh ufa\nrwr eph obg peh pejret prjtee ovgz\nvdqf vdqf ycjrg ovzl lelbe vdqf\ngvagdqm gvdgqam dmb zaxe nepzwn\nemwh bkkbgec qwdgk mhvfsrf wmdfpp ekzuua\nmbqw lgkyazt ckyhvnq uladwo owt\nqwiwd pbo tkjoqda zapo dygqopv zzdlwfn\nqty dhb iinncba ytq kvh idgoevt chx waq\nulffsvk vplsz ulffsvk uxsh cpwgxd ikgcacx nrirke uowcjvn\ngknmxr grkxnm fco dilyyj grmxkn\nsaqxkh uhue nvu fef xsuxq ekyyoc bcaavd\nqltwqa vrmpv vhra nof yprauc vkreojm eaq igiy mec\nwvheiyg uthy gpvcs nhnjrne mqaejr tfnsly zfbhn entcc nystfl cpq\nzxv jzk dwsjgrd gqqxhp xqxu naunwc yeh qzpkz awcnnu aoosa icadax\nvpmqmg qmvpgm tqs mvpqmg\ninehzu zwxeoy jxia fcyzxc hwikd\nbzwnp kamsen ajpn kdls bzh xqcb bzwnp cmjnfa wmgx\nhbuhc qgvhxy smzkxh zzebox hbcuh net wyrdppc yvgxqh\noeum oemu iyags xaipdi euom\ntqljgoq ghtdhw xhnni lux qltojqg lki zxztda pcqjif acpzvwy\nydijaq kbyjxpu onyd hsfgz geqvbg\nrwoih xog dtbzyr ryzbdt tdbyzr\nvcdxf zosw pardxfz bmb mscmain lwfc jvq hbszcqh fxomsmm ahnugx\nzutsemg pqzil ddv nsstz gmeuzst bedvy xkzzjpw xlqbd\nxxf ltnnu yeb hbml agj meovtjr qrul kexerkw xxf\ntqrpd hhcx bmdv nlmr pnu pajdtc rpatqi yekedx oeiuew epsshog\nttbfpv plairk toh jagfsg njnqpa tmwh vwqp irtxv\nvdky uwc tkkkztp vdky vdky qlcw lza\nrzie yundymy pwgx wtwtbg kpiw mewnb liveysj uvsbn\njgfvyny hacg pzra arpz uowswu puzsfu hoe heo vrq naup\nhqv vrl uko qgpikho lligvxa wdld qgpikho\nwhvby yomxwj dieffc jkprinh dsaqy yfrnba woyq yexeb mjn cbszn xeswvvo\nwowtgu rciyg rlas bra quyfec ihe thuu asxhscu bsbdpbi ogxosu\nvydsaet tvnkjq piedkzj foeiqz zqivt iatsju tjnqvk drauaf vqitz invoz\ncppn jqzw zmxr qksuas iifmjg xtkgf cppn cppn jpsd\nnkifpsq cxdx bokxhm ebww kghagrp bofhrl grc cheuzyj\nibgrlvm hrcx jjuoh ipmt\nhcoqkh fzt rgravb cimauj jxjq blct qhc vjxw pqpg qzp\njycxz xcv czxjy vxc\nliljaur cgmg neldxb xfummcq yfhiukd dnqhl iolxn cmewhb\nhpvoihj fkwokod txy uuktw vmqqb dpldzh yxmcay cyaxmy xycaym wekr\nccnaf wuxc ecadb vbgpt ccntf sezo skjdkbf fnctc\nhqdtwho kdhyman bjtcjvr bwllva ncyffyr\nxprn jrrvmj pdw yvexm ewbflbe eapml rvrmjj xmevy rxyzhf\nwjcbpy qdgtcp cfjh muww fhg sgfdleo nelpte yucqa aavev\nrci vqypsqt xmg rzii\ngramh wwprtc ampdhw dajr\novrm mdyhpbl mdylbph aykz\ncbmo fxs nuugu guunu upt ljjuhjw nituh utp kxqc\nrhabal rhabal rhabal vah lfrs\nnrq qway ftzp rtjcks mbygdtd hsiqbh wypqb rtjcks cllp hsiqbh\nywa anhcf nvd puqkwg molrwck wsctx xvd molrwck\nwox jzq jfen wcvus cswvu oxw irg lmu tpj viahm jesic\nqenad neqad smlgi ydwzq ppdemvs ucyuf qtunm eoqx jlgv\nsucpl nrdwbl ltvetok npbw ozzw hafyay sjmui sjmui jkqlq pyn pbuopx\nnxgaiu ybyl meo kgh saqjaz xhbqr otelcyp vkwc\niqrl ldjlwvl ajhrl dnhutr gkknyqs mcvluet fgyu ogiz cxo aiunl orb\npsd cyq xpoyqny yqc kozqh vonfd uhozwz pds hcpw\ntvaxder tulwmw qiw avddbmh irog vynjzcc refx efxr emnvk\nmyjx npqk whm egw kpy igrrohg ukglx ldnuqw caqg ynx fckhnsh\ndafv bkdoqg zcqvbco xgikoac cvbqczo\nrtzhpwk ukuyp bayhzp upkuy ahbpyz\noarcuv pnlkxvw fqdkj hwzsz nauwl lpufibz vzfbgc unkluxy rwh xuknuyl\nvxhsaj ppdxw qrswqtu ulwv uqtqwsr ppxwd\ncww cww cww scu\nwiiikwa bfpewt zbgxfkl iqpk tpbwfe aazdcxj ipqk icggn fwn fjr\nnet ovxuwpz yvzmzd yvzmzd\nxgar czuhp vuhisaq fgrqxy evvrtf mnmar lsk\nhld mxuedug itswju vmmejqx snzslqj toe bbmugph mgubhpb mowj nrjnzu\nqbz ouhye hsldmp lcf hyhlrb ewvle zko\ncke mupaq quapm eck\nowu zdt lales tzd apjjo fhpx bmuktbw dvehpz\nlibvl zxypk azazc vtsom ohdzycb\nkiowxnc scxygrf ckxnwio ycxsrgf\nvcjj fqz lfawfx mps zhv qykch vhz psu zud spu fnpvkx\nscfvum fuktgk tua ieosetl wwmjtt exnsw wwmttj plvd pfb kku pdbom\nwkfw snukd wkfw gyaojdf bjw htagy cdsp\nbeh gatqxcu ibrooxr ssww orrioxb eenkqz\njlv affah mtbemf tylh aafhf\nzqfajd uwzrw csouuip qzadjf\ngsnlrw tcel hha tfbzrp ild aenqa\niirfxef kdux yvj vbzgj\nibx pfll rgkp nancij llpf xib gbkfy\nuvw kkbavj pznsnk okigtxl ogitxkl eobbs xhaz wroabn ltogxki\nbivdf lotvmoh vrb kpaeeue tdab qhukcb qmy kuqf kesu\negs hbsfeu esg twxko uib\nocraimu qilp ijmx eco nhevqp juxf ksejr bcqqau uhpt\npyx jmpglf juokd dxszjw cml vcjge pfg\ngxwrt btmimse dkpbha idmz mtignka ngakmti\ndpjhm jyalra hukf imocr lkgt rqywn quhe fukh\nnbau xyc bdh yni xaawxm cyx xwaaxm akx gyodqe htbifc\nbywdxe bfrp rvb rndl onal jghiwb nuta aint qlciwcx\nfpic yrqce land soxhci qzc zoebsq hcdohcc fzhcl iyxb dqinum hchdcoc\nzok ghgp zok lmk\nozfz zofz dkdekzb sqc\ngfti zuqvg cexmtyl qwuqnj stepb erduqhy cuoizcs qudyreh kqvfdd guzqv\njrugz jzugr lmqu jgihgo hjfbz duxkn unxkd\nckiys dbqmi ckiys ckiys\niylp uvvdp pluifaa djo\nesxec rwvel djxppqf jymwt ilm aiz upn aiz wrfefwi rwvel\nnitgjr pokxuy puhdwg qtxpb veylp zqvzkbd lrvpcgu zuy rnigjt ibci\njboyzq ogcldr hlon ywav jqqtz qjzqt vyaw cok\naqdw jxn hqknh azbylg\njya qpxtmsj hqrtsgg qjtpxsm\npofcs sxw dlvru dlvur swx\nyphvvb qqyyfsp sjkbff dqyerxe jxzes oof\npwbya txk bbwsj ywgimd kmdpc bawpy lbnt\nbkbazff ldmaq tyfl acqurpy ndnrp\nasw ctiv mnxzyc weeuwb gsn bzk irbyhxl cgqomj izy zbk\nyrxcrbt bcrryxt pofe wwzl\nvuaqez kbtuyai vuaqez dxqud uvo gmhtg dxqud\ntpzs gqdxpxo zzpgta uurjx xpqxodg\ncil lsv vznqw vro zqzvjhm jhgauzw uxnwk lci zpgpu frjvyzo tsv\nzfvcuim gwn gnw dxfppok\nbtb goof iwadca aac tbb jha uvzi\nqah ned ipmure kyta ffhrwe njz paq kaag xmlui\nrkmw vrblwyy gpax hxsf zpbza gypuwf jbib ypcjwd vrlybyw\nyfjljn uxpvg huik jsnah nkhsg yfjljn lqzsz\nhagjlqx agnax jqalxgh rvjgtc mjrmph azznzcq gxajlqh\nipki bhoabp rmiyl dmjyxl zzsmap aju\ntyjrr rigrf ciq qic avmwu jtr wpq\nvuf cosgytm toycgms ufv qzpcbrs\nepzgxr lydrsj ezxrpg expzgr\necm prj kmak makk jpr\nccwyq txy okj matxa socoa\nzrjphq gigayv ywkfmru yrwukmf fxjjrha gqkxx zhjy tisutx kufrywm izjfj igg\nlfhgsro gsroflh wrpo lofhgsr\nkgkgj wkhnab ubrjaoa ubrjaoa ubrjaoa ggdgh\nhztutpn epnqmz ffcroq mnqpez niibpn kdloak xjui ozttj lyzsc pzgq inpnib\nkruz sjqp mmd hhdxjgc mauouma asevvo upjwqi hxcgjhd etqzagp\nzylf qime cho oraid svytv gqrjufv mker cho vnkyiin tjms\ndotjul qyv hnh cibtg gdpauyx wzp\nfabtira ejxoeor cqyethv ndjrq hnxn joq otng lrr csytrub\ntxhgepd fwdaanm nawdamf pxine qqrn pronw exnip qwkimt rvy\nkuxzhi jln urzxtw rzu ebsuylm tscru qwlhfgq nnu nuchvz vuht\ncqgu camlr umkltcf stx izp rtdwxff wkfvs\njhje cxix lefcrsu nebv idfzhic xqri xkft\nutzxb znb ietupd uqgbhje aobip oawjwm hetyan uqtqv hpwzyri kwxyu\njvzvbt xuyvp aegdkb srbw bzabpf lyfriez cruyfu\nnhi nih aeb ihn\nhcf zypt djcm pkjx pvhh\nrhvxcfk exydvk ids hybme hnk yfchvs mjbo meocn\nrpboxr rxoprb hdzje zhedj\nziildbo apzvatr vsv isndq ebxyy ntm tdttg wkvdh qnids vkdhw xxolip\nywu uyw ipcjz pjzci xjn kvgk vsocprw\neuzo njlpv ndrlhi drlnhi ivmjkb fjrtxta skvgmrd\ngbyvj dkck gevpfvb lhadhx rgjcdn yraxh bdk oen vqryd bkr\nvgkp hncttxb wgxh gdyjo bbdfzvc xhgw rznzgda yxrrlo gxhw\nifjlb fpecyic svhjp ilmj oxgr svhaf\nvbqky lhccj xtmm xzjyykn oqmdq qywir bswly\neuxxziv totzer vsxfx leo djho uoeaz edaig fbu lumbi\nooqtwq pvo kid vpo jxin bod btqc fbyuz\njhabi mronu htqqyz umjcbv sgnbp wyn cetmt pcjf\ntnrkcyl dduuhxh rylkctn pwj rtynkcl mzzfomr\nrxx ldqffi ulappk nltawbn tplhb kyb cqyi\nvzkw gviooah vxh xeae ohvcad oaiwcj dkx\nsdofdjt hcifv dqws sia mlwm vfich kavh myzue roops mzuye\nuxs nlbmjp nlbmjp tlaxa tlaxa\nynnisp twx xtw jgkc yinpns\nkumorsm wav xhx bpvz clqc ffmadzl ndny ymslo lobv\nljzabj tqhves mezh pwn wue dwfqq lynvtt boeknvi xqbd pkud tzlanis\nlgq qiikzl oihnsr pivtjmu qhic yvmeebg rxu qgl yuxnqse dvu faxqez\nldk mlwja vmdqr yzlxiua amlubt ejmzfx nonm zhkxbn gaqbnqq\nttc ctt kneknx smtnaft abljip tct\nuybhbiw zwojzlm cfxoopp abulenj znz zzn opllzmm yufk witwxzp\nqvkybwi rdbxb qiuizmo fqgne jgot jxz dqhapn\nvzinf ehaley amnk laheye invfz\npedakl ivld agzyhr wmzba tzzzg bazwm wjwgux thrnxkn\ncmyhae nwfs nfsw kmh pxkaffq\nvdf szupev tyunp qiiu deevxmy wozvtt nelnr kgdexy gparqj hajavz biizn\npwspk skpwp ontbjee pkspw cfbj\nihsmh djxtak wkzllao oyr djxtak prc\nuhvihqq jrgf hdfek pdrfpt tghz gthz awae wcygi wujti svq fhedk\ngnfhsj odqlt netmsul rviio nkzw nkzw\nxyvc clxw cyxv lxcw\nduegck pkviu npwsp zdx wpvn dmxgnv ixv fybs xteru\nvih kgk hads boaddu daiwo hozoufv nef vtcplc isiw\ntzqoo dqlgvno jzlay sywx ecej addt ecej addt mnfcu\nymgmby zegudpx ipsjai ger wcwjw brzebb\neqekxlx itra xekelxq exqkexl\nrciu ojaa ircu nxjga puvmwou remgu\nsltth pprimb slnxopq avtir hvpv ppww fhfap wisn kzs jcuuuuf\nxbppc ydpbq zhjh oym iljzvk vsb\nueye shtps uccehi ccheiu dqm yeeu\ngwywf lcpv qza qza gzuovj jfzffyh oybfxqv\naawi ynsvdco azdoz cqr tnyquq xlyvbx eca kcalpes\nzumgzhy rou kguqa vubw bwgd qprxcg etnbev nqmi\nfyd tuoz uwclqn cgl lrpkf irz dizv nxze clg jghx jbpt\nkwuanos eorjr tcahp kwuanos cyrpfji zxayggd kwuanos jkqt qqvbork lizk\nvtu ovje vhg ovje vtu zcy hrhtr puawfgv\nbliz exp wot svxv epx\njiqgxwj yips hjsatc jgsrno msfp vxvbt bba bqmw xjgpgog\nvpvypp ggwp wggp gndp hedpse afji hcqgof\nhxueubt hiynoa qqzaj ohb qway\nakq nfnes sdrlza nfnes weq\nudxpdpx gctuv llhxuow rqtetm hdbnpte oebapv civy oeobu ftgivd pykj\npbgbvn jgmr xrz dfn gosjobw ndf\ngnf dtbsnc fwcmml tscdnb fgn qgadusl eifpk\nvmnv yuxrup qcphi tanc tnca kjrv cphqi\nhclggs sghglc fgplp odn pfglp emkrulf whwtmbs qnuyg\nwcxtr ani ain sha hsa zxbkf bzxokat qezo ljqxi xqcwfmd dxo\nwaiq smpbu dbyka uibxjrg nze wiqa rfpts ddjsjv jqqjez bpusm\nlpcxf vsbj owjwc tuqj vkrgrh jsjdepv oil lxrjox frsxsi clr\nvzunp prwk nnd rfs vpuzn\npqpqv lvsk sqxf nhobsm hakbn ywj\nxxu uxx szqnmi lnwtmx\nakq nmlw fupwsth jduvhva\nnac wwlxqck hpbce vxxqa fyp xvxqa kxwclqw yvlmv bfwi\npzxjbj nvwv mdooiez vvftp enjrsck iypu uhru fpx omtd\nllxgp qwf pwaj cuhb scloot hbcu jgp vjw ooclst\nsisd akawvzd wvdzkaa gyoij ikt eeeosb jiwiup\ntche vxj sbctqv jvx gosur usgor ibo yqxo qqgd zspl\ncidd welisl fxblxqk qxbklfx fbdoqcz glhq iylodvz zvds ghlq\ncnsa hrxst mrnkqtj bptq jmi cpbcofs kveyeur uzmga modphm rtx kntqjrm\ndvyup usfaq rtghoec bvcos fqsua zohwwg\nonf vncybi dlaxni oqyqqkn\nokfwa qyyx ebnv llql nphq etdt ytgivlo jwgwz kiob\nann vqnqvpx wth lpwid bjvzw xpwqxcj azg ioeyzzp onwf\nsmy epzomx xep yid zctvrfj astdj cfg fgc eriuxt\nrljqgin wzobzrh cuwtx vcsbx tmg tuysq vxipgho\newp rsrnsj wgeyin lrji ddgt utol xxwut fjiwopa\nupu ftvqbk tfkvbq fdwga rmu puu hbiasjw\ncfl lmqkb lfc wbtlfi uqsjs ejgmphi tbliwf nzcela gzb\nzop unwmiu acull mkwh hvruknw rfk mmhaz iqmenq fifino\niczua bjut tlgf zicau jtbu\nmtka ipd mdifj kps\nirqkysw xfsjl tedx yckkbx iktxb sqxn pbfvubv uudzppz\nmdrn cihat wcext kufs awwtjok pfjg\nwdevt tyo zzbp pqlqq wdevt\nyhatqkv ntuhw tdfd buxazh xbcsv bas gkv rbzi tddf jbj bsa\nmalip hiiy qezz yhii wlfojre\nzqnfll bssveq lprwbep bhqml tztbt\nnpnxotu yupdytb jptqo klfydfe fpucmfq svxcqr unopxnt\ngdpz gwj iytiohu efk ctjzf asade abhotq brmhu tbtdur zzksbh\nkxft klzslf tjdzciy lzslkf\nejei ezmemvg xlt zte tbwhz dgnfpao zotck wus uaz gbwbb\ndgednf vypmbs eiytot empfmny\nuopmui uehue wdvzt adpfcif mutl ifaztka vydi xumtz orstno\ndleero olxiq gxnlfm nfmxlg wloeavr olhrwg hrjd yicj ymyeex qav gxyjgfq\nhevj rqcne zycgb qgqtn rqcne ptfvu yyyu zlm hevj\nzrkhuh sttnkt hkuzhr vqtu\nppsfm kcao qjq dgadglx cxaawjn pbucfu fed qgioarc dfe ricoaqg\nvmawf oktunea zraoir gkt zraoir jcvkqoq\nmqgml ecawug ugwace szwul iwbmooj owmiojb\nauggaw cypcuw npci vuyxijd pofswjx vdkrgx xylk rom ksj\nqmwx jgsrdj ikva xzxw avik\nzzhcqu rbg pywjdn wyndpj zchuqz\nwzd wqycftu yldezp zovuy oydia hovewe\nkfid qkkk thak qhbf rvzlzvu uuxh pbj hkat gow oeqcw knqqzha\nsua itv hfpg bdqye bznlrk hfpg bdqye kvir kaai ggtz jqn\nulggl guitamm tkpckso fupacz otxtqpd jxnqc\nueesb ndyik vjftz jgqqv nrcf\nkrh dqpmsw fybzynl zhjbvkw exefc rhs neq ldprb bhhvxm pjwirun\nymavl qwxr yavml wagwc ekokrpq zewppw iumcgin cxdvwx\nwwdukav kuawvwd kowv dkwvuwa\neazot bil tzu vdwwbm fvauwrq\nesq tixokph yspf ztoxfut lgzush pwv swh pwv auqhuu tixokph\npdbeyxi poio mugfkb brwbbx aao uszw fokjeb uswz\nsbs ryjr ptispi tvnhu htunv vthnu\nczjmg hbdjhvi jrkoy fpgwc syafy aar kvnq eaecsb wqzpx\ntwtp dvl uvyje qtlzj dsvyr qpjnj eyoigx bhgpccy gwn dtuf\nmxit xunctu vbyks wmqc jriuupl ybvks uncutx nsoxwrb ykt prc\nyye mgf uhc irowpc dsdv iwaxod ftavlj dxzp tcch tcch mefz\nrxe xwrrgl xwrrgl duu rxe xbbgoe\nucsz akswcd ojrmqq cox hgfh lxwu ltnnf cenikcp\nopjhdp svwezr svwezr opjhdp\nqojlkl ircxqnt utfmdg fcvr vehkcvt ufmzcpv xwlh ddavv xel bwlz fii\nrzkayeh iursm zhily hdnq fqydfvt uwoy hptpiqu tdqy bgr xdr\nymruz umzry hbltwya jhwhzk flh tahylbw bdbaimb qscbp ntkuf\nuxpato owsqyao vaog oenomkc usrmnc epua vzkppls\nqxqczbk qyguz alawj xgjawtw wxtjgwa snfcdmz\nfjfgos rmpd mgs vbk dlls jkljao eoovdfb ucdvaoq qmjmqku ney porr\nnmcrqz zcoxpk dlnzksd ymh zyg spxss ruyk bychq gsgv eusiuid mnrqcz\njbzadnx lzl sdamer okoico frqisrm lxet agriw\nxceoqr qai vahc jjzifsn exg\nigjpn wfy ukn aag quro wklsq cjq bgtjrdz gmub wyhh\nfzlwnm mygfn vkzwvw zvhsex gfki\nijvzgai ebmeq wssfmbq uguh sfuutm nwkgmex dxael liakdxs rnf sky yowpxc\nbjzkyjh fced nji esowk qxsubsk qgtts\nnkdgo bbjfq fgnxnhd gfjchl jetdb xubsgj eiju ldlm oxsx znft bbqfj\nxovcnob pxfe pmstes yzkdm iqlvha nmcziix fexp ivqalh rxecqps\nxpyew xudfud wwqe qhfjlcu epv fnrbgyv ihli qngtx yjlfg ozqbzn esp\ntiml gcohx vqzic gzm shwlkkv icqzv urchuc\nxpqq gaqzwo cci dowahsr gaqzwo\njjsagdl umbpxre kyre zvaryft tmw pxpnjy\naqovcz nunq nnuq xjrvvh autjmit jiatumt\nelg lps lge zjjot hwz tmqrup xaxxmo zlbzp uftd fukdad kvpymsm\niokwzal ywti zbdmzbu lprywe wbgbwza ypogbga kzliwao wstqi eqm keaeaj gbabwwz\nlwfpk mhufe eddzgd ljxyqy vhzkct uemhf\nlwqil fzugdo faq feppo usl llwqi\nnje hthr ropq qvcepu bexszfj avmzjvv zajmvvv fhcd xnc cnx qnuaux\nkvksn dphbyz nsx wrcc ccrw\nnzpa pzzunfv ygzjy gxrrtcj hrt trh pwxpg yifgjmo fnupzzv wbzx\naepti rbojui ypvhe ubojri tcema aan dntkw qjx bfvmyos tcm hvoqytn\nqpwq exu jvsiwj gsw avr vbemldy\nxsbzpf xbzyvx xax sxh vpxt gccy xxa zhgbwoa hwwxoky fhvdxfc pvtx\npnsa ovtjolz tyutl eyjjzt jvtoolz owbypvr tytlu ewtzgec\ncyg dwwk eihsp aeuk bbnay aluwyz hdmv uaek mwt ihpse wjhnkeg\nfhzx vjetz vjub tejvz\newwyb jidhu pyvyenn igtnyd tiwr akwkkbi myz xxjwb jjrdeg\njbkuw kwir rkiw ubwkj\nbltffuw lftwufb hhsh wfbtulf nrxaa rlszi toijxnz czlci\nbqrm pga zgblgcw pgwhhn lcgzwbg bcgzlgw yqb\nmhjj vjoa gnjlc kclcr ito ofksy giavy fpqeioj\nbkiqmif izidbui sttxxi bswhkxp sduuw\nmjgnvw mjgwnv ojzyuv gvj\nqxn kkhc whd fgwk auzugg augzgu kqfov wfgk\nspdxbnu xpfofsb bpfsoxf ahjywql spbxoff\nbwqxhlm wbqlxmh kqgpl fyzgf guhkvgx ovk qhmp gnrmu wvd wedj\nvvwf hcnc vvwsngj qedzoxm hcnc qedzoxm kjthdi cbwqep qtvu\ngio iqklmro noqablo bab jiqc rwebyg rqkloim wzmgs uunl amqs iwj\nsnxj szobqt zcgvwv wiyqknu\nuto jteikwd cew gqsks hmvjtcy sach\nzpgl qnkoex amhufmr figns upv xezrl rjleak nwrna\npzkvrdz dtonazj gtr gfxucuf lstjl lsjtl rgkope kzpdzrv lyptn zfxjys ttk\nddxgm lumlgki jhv doft kok swy ckds swy ddxgm lbfbdv\nqfs rcufzgz iaiqw qfs qfs\nnvkbo sgv mquwb ritpye nbkov poex hraorm qrrr qdt qefl\nirxannd fiud ehyb ggx plqg pvvn uuptop tcvbm abuf bcfnmw\nqwya ukblz epmbfr vmlon yqwa\nhlo mmv vmm mvm\nsvzpxun yugbbe sbbpxs dmy xspbbs zhpovyf fyovhzp cpbt pke\nzgk gft zybs zrgcoo ypu bue htgo\nxnesq srsx pkzaoh cfqzugh\nlntd nvxetbv clykjpd svmibpx evxtvnb yldkpjc\njsqq tzwak hephg eqwczd ioisa yim tmdifn mceip\nkuwqz wzkqu zwchmj lfec uexne iztp llityt\nkvamkpc pvbryqh ion cwizjde gln kcpvmak pzzlw gnl\nydeqf bfaab sydqhbp smsxdjr pynrs cqymt\nonb eiab bno nob\nmqslq scnelxv hyllrf scnelxv mqslq wmnbk\npttu kubby lgop bbyuk gsk skg ikktlbb inbyvz\nxznvl zwtdj vbxdyd clhw\nhgy zudelp ickc drfjgn iyws xhc\nzzv wik iorhat qkb kjb lykdz vrce yjsjwj\ngyw xzgbi efus uuy\nhwcy ujdun bjjuvd jbdvju onnk xeyy mmp onkn qyzl\njwfm ptjwrbl hhuv uolz adyweh qpj wxyogp igvnojq jmfw pqs fsnirby")

(defn parse [input]
  (->> (string/split input #"\n")
       (mapv #(string/split % #" "))))

(defn valid-count [passphrases]
  (count (filter #(apply distinct? %) passphrases)))

(comment
  (valid-count (parse input)))
