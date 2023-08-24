# jdbc-jpa-task1

Öncelikle kullandığım dependency’lerden bahsedeyim bu projede
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-jpa</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-devtools</artifactId>
		<scope>runtime</scope>
		<optional>true</optional>
	</dependency>
	<dependency>
		<groupId>org.postgresql</groupId>
		<artifactId>postgresql</artifactId>
		<scope>runtime</scope>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>
</dependencies>




Nedir bu JPA ?
spring-boot-starter-data-jpa: Java Persistance Api ORM teknolojisinin standarta oturtulmuş halidir. En popüler ORM(Object Relativ Mapping) hibernate teknolojisidir ancak mevcut sektör sadece hibernate ile sınırlı değil eclipse başta olmak üzere bir hayli orm teknolojisi mevcuttur. Aynı işleri yapan farklı isme sahip teknolojiler ortak çalışmalarda ya da teknoloji değiştirme aşamalarında karışıklığa sebep olmaktadır. Bu durum geliştiricilerin ortak bir paydada buluşmalarını zorunlu kılmıştır. İşte tam bu noktada JPA dediğimiz standart ortaya çıktı. Esasında piyasaya en hakim teknoloji olan hibernate baz alınarak hazırlanmış bir standart olsa da diğer teknoloji ve kendine has özellikleri de barındırması nedeniyle ve ortak bir standart hazırlama arzusu ile piyasada hakim güç JPA standardıdır. Bu kullanmış olduğumuz dependency spring boot’un bizim ihtiyacımız olan arka plan işlerini yapıp bize hazır hale getirmesini sağlıyor.

Sistem Nasıl Çalışıyor? Hangi dosya ne yapıyor ? Akış nasıl?
Projemde İstemciden gelen istekler önce controller Package’indeki Controller’lara düşüyor. Controler gelen HTTPS isteğinin url’sini ve methodunu sahip olduğu tasarıma bağlı olarak Service package’ı içerisindeki service class’ındaki uygun methoda yönlendiriyor ve dönen sonucu return ediyor.
Service içerisinde bulunan Method eğer kendisine gönderilen bir parametre varsa(bizim projemizde model ya da id’ler genellikle parametre olarak kullanıldı) bu parametreleri de alıp yoksa direkt Dao interface’ine methoda gönderiyor ve gelen sonucu return ediyor. 
O sırada DataAccessObject class’ı Dao interface’indeki methodları @Override annotation kullanımı ile database(veritabanı) üzerinde crud işlemleri gerçekleştiriyor. Eğer veritabanı üzerine veri işlenecekse jdbc.Template.update methodu kullanarak String tipinde verilen sql sorgusunu ve id, name gibi parametreleri kullanarak ya da model üzerine yazılmış verileri kullanarak veritabanı üzerinde güncelleme yapıyor.
Eğer ki veri yazma işlemi yerine sadece okuma işlemi yapılacaksa jdbcTemplate.query() methodu ile veriler okunuyor. 



Peki nasıl?
1) Dependency Injection dediğimiz bir yöntem ile bağımlı olunan sınıflara olan bağımlılıkları soyutlama yoluyla azaltmaya çalışıyoruz.
private final JdbcTemplate jdbcTemplate;

@Autowired
public ProductDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
}


Örnekte görülen dependency injection türü constructer kullanımı ile yapılan DI türüdür.
2) @Annotationlar kullanarak Bean oluşturma yoluyla ilerliyoruz. Bean’ler uygulama ayağa kaldırılırken IoC içerisine atılır ve böylelikle her lazım olan yerde yenisini oluşturmak yerine bir defa oluşturulur ve lazım olan yerlerde kullanılır.
Bu sistemde kullandığımız 
a-Id:Bir varlığın (entity) benzersiz tanımlayıcısı. Genellikle veritabanlarında kayıtları ayırt etmek için kullanılır.
b-GeneratedValue:JPA (Java Persistence API) kullanılarak veritabanına yeni kayıtlar eklerken, otomatik olarak değer üretilmesini sağlayan bir anotasyondur. Bu, yeni nesnelerin benzersiz kimlik alanlarını oluşturmak için kullanışlıdır.
c-Service:İş mantığının uygulandığı ve genellikle kontrolcülerden ayrı tutulan bir bileşen. Uygulama mantığı genellikle servislerde işlenir.
d-Entity: Bir JPA terimi olan "Entity", veritabanında depolanabilen ve işlenebilen veri nesnelerini temsil eder. Genellikle bir veritabanı tablosuna karşılık gelir.
e-OneToMany:İki farklı varlık arasındaki ilişki türlerinden biri. Birincil varlık, ikincil varlıkta birden fazla kaydı içerebilir. Örneğin, bir üniversite (birincil) birden fazla öğrenci (ikincil) içerebilir.
f-ManyToMany:İki varlık arasındaki ilişki türlerinden biri. İki varlık arasında çoğa-çoka ilişkiyi temsil eder. Örneğin, bir kitap (birincil) birden fazla yazarla (ikincil) ilişkilendirilebilir ve aynı zamanda bir yazar da birden fazla kitapla ilişkilendirilebilir.
g-JsonProperty:Jackson kütüphanesinde bir anotasyondur. JSON serileştirmesi sırasında nesne özelliklerinin JSON anahtarları ile eşleşmesini sağlar.
h-Table:Veritabanında bir tabloyu temsil eden terim. Bir varlığın (entity) veritabanındaki karşılığıdır.
ı-RequestMapping: Bir yönlendiricinin (controller method) belirli bir URL isteği tarafından nasıl tetikleneceğini tanımlar.
i-RestController: Bir sınıfı RESTful web hizmetlerini (JSON gibi) destekleyen bir denetleyiciye dönüştürür.
j-Autowired:Bağımlılıkları otomatik olarak enjekte etmek için kullanılır, böylece ilgili sınıflar arasında kolayca iletişim sağlanabilir.
k-PostMapping:Bir Spring Controller metoduna HTTP POST isteği eşleştiren bir anotasyondur. Yeni kayıtlar oluşturmak için kullanılır.
l-GetMapping:Bir Spring Controller metoduna HTTP GET isteği eşleştiren bir anotasyondur. Varolan kayıtları almak için kullanılır.
m-PutMapping:Bir Spring Controller metoduna HTTP PUT isteği eşleştiren bir anotasyondur. Varolan kayıtları güncellemek için kullanılır.
n-DeleteMapping:Bir Spring Controller metoduna HTTP DELETE isteği eşleştiren bir anotasyondur. Kayıtları silmek için kullanılır.
o-PathVariable:Bir Spring Controller metodunda, URL'deki değişken parçalarını yakalamak için kullanılır. Örneğin, /users/{id} gibi bir URL yapısındaki "id" parçasını yakalamak için kullanılabilir.
p-RequestBody:Bir HTTP isteğinin gövde (body) kısmını belirtmek için kullanılır. Genellikle JSON verilerini bir HTTP isteğiyle birlikte almak için kullanılır.
r-NonNull: Bir anotasyon veya doğrudan kod içinde kullanılan bir terim. Bir değişkenin veya parametrenin null olmaması gerektiğini belirtir, böylece çalışma zamanı hataları engellenir.

3) Ioc(Inversion of Containers):"Kontrolün Ters Çevrilmesi" anlamına gelir ve yazılım geliştirme süreçlerinde bir tasarım prensibini ifade eder. Bu prensip, nesnelerin yaşam döngülerini yönetme ve bağımlılıklarını enjekte etme sorumluluğunu programcıdan alıp, bir konteyner veya çerçeve (framework) gibi dışsal bir bileşene devretmeyi önerir. Bu kavram, tasarımın daha esnek, yönetilebilir ve test edilebilir olmasını amaçlar.
Olay sistemin temel gereksinimlerini framework kontrolünde işletmeyi sağlar
4) Application Context:
Application Context, Spring Framework içindeki temel bir bileşendir ve IOC (Inversion of Control) prensibini uygulayan bir ortamdır. Spring uygulamalarının çalışma zamanında bileşenlerin oluşturulmasını, yapılandırılmasını ve yönetilmesini sağlar. Genellikle "Spring Container" olarak da adlandırılır.
Application Context, Spring Framework'te IOC prensibini uygularken aşağıdaki temel işlevleri yerine getirir:
	Bean Oluşturma ve Yönetimi: Application Context, tanımlanan bean'leri (nesneleri) oluşturur ve yönetir. Bean'ler, XML konfigürasyon dosyaları, Java konfigürasyon sınıfları veya anotasyonlarla tanımlanabilir. Bu tanımlamalar sayesinde Application Context, bean'lerin oluşturulma zamanını ve yaşam döngülerini yönetir.
	Bağımlılık Enjeksiyonu: Application Context, bağımlılık enjeksiyonunu yöneterek bean'ler arasındaki bağımlılıkları çözer. Böylece bean'lerin kendi bağımsız şekilde çalışması sağlanır.
	Konfigürasyon Yönetimi: Application Context, Spring uygulamasının yapılandırmasını yönetir. Bu, özellikle özellik değerlerini, veritabanı bağlantı ayarlarını ve diğer yapılandırma bilgilerini içerir.
	Aspect-Oriented Programming (AOP) Desteği: Application Context, AOP prensiplerini destekleyerek, uygulamada yatay kesim (cross-cutting concerns) işlevselliğini uygulamaya yardımcı olur. Örneğin, günlükleme, güvenlik ve işlem yönetimi gibi yatay kesim endişeleri AOP ile ele alınabilir.

Peki Kullanıcı Nasıl Kullanacak

Kullanıcının postman yardımıyla ya da frontend developerın arayüz tasarlaması sonrası kullanabilir.  get methodu ile /category ya da /product yolu ile mevcut bütün category ya da product table’ını görüntülemek mümkün ve aynı zamanda belli bir category’ye sahip bütün productlar ya da bir productın hangi category’ye ait olduğu da bu method ile çağrılmakta
post methodu ile yeni veri eklemesi yapılabilir. json verisinde category insert methodu için name değişkeni atanması yeterli oluyor zira id verisi otomatik atanıyor.
Productta ise veri atanırken hangi catagory’ye ait olduğu kullanıcı tarafından seçileceği için category ataması ve product name ataması gerçekleştiriliyor.
delete methodu ile url’ye verilen id istenilen category ya da product’ı siler. Silinen category olduğu takdirde category’siz product olamayacağı için otomatik olarak o category’ye bağlı product bloğunu da siler.
put methodu ile update işlemleri gerçekleştirilmekte
