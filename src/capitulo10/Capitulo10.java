package capitulo10;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

public class Capitulo10 {

	public static void main(String... args) {
		
		// Forma antiga
		Calendar mesQueVem = Calendar.getInstance();
		mesQueVem.add(Calendar.MONTH, 1);
		
		System.out.println(mesQueVem.toString());
		System.out.println("-------------------------------------");
		
		
		LocalDate mesQueVem2 = LocalDate.now().plusMonths(1);
		System.out.println(mesQueVem2);
		
		System.out.println("-------------------------------------");
		
		LocalDate anoPassado = LocalDate.now().minusYears(1);
		
		System.out.println(anoPassado);
		
		System.out.println("-------------------------------------");
		
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora);
		
		System.out.println("-------------------------------------");
		
		LocalDateTime hojeAoMeioDia = LocalDate.now().atTime(12,0);
		
		System.out.println(hojeAoMeioDia);
		System.out.println("-------------------------------------");
		
		LocalTime agora2 = LocalTime.now();
		LocalDate hoje = LocalDate.now();
		LocalDateTime dataEhora = hoje.atTime(agora2);
		System.out.println(dataEhora);
		System.out.println("-------------------------------------");
		
		ZonedDateTime dataComHoraETimezone =
				dataEhora.atZone(ZoneId.of("America/Sao_Paulo"));
		
		System.out.println(dataComHoraETimezone);
		
		System.out.println("-------------------------------------");
		
		LocalDateTime semTimeZone = dataComHoraETimezone.toLocalDateTime();
		
		System.out.println(semTimeZone);
		
		System.out.println("-------------------------------------");
		
		
		LocalDate date = LocalDate.of(2014, 12, 25);
		LocalDateTime dateTime = LocalDateTime.of(2014, 12, 25, 10, 30);
		
		System.out.println(date);
		
		System.out.println(dateTime);
		
		System.out.println("-------------------------------------");
		
		LocalDate hoje2 = LocalDate.now();
		LocalDate amanha = LocalDate.now().plusDays(1);
		System.out.println(hoje2.isBefore(amanha));
		System.out.println(hoje2.isAfter(amanha));
		System.out.println(hoje2.isEqual(amanha));
		
		System.out.println("-------------------------------------");
		
		
		ZonedDateTime tokyo = ZonedDateTime
				.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("Asia/Tokyo"));
				ZonedDateTime saoPaulo = ZonedDateTime
				.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("America/Sao_Paulo"));
				
		System.out.println(tokyo.isEqual(saoPaulo));
				
		System.out.println("-------------------------------------");
						
		ZonedDateTime tokyo2 = ZonedDateTime
				.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("Asia/Tokyo"));
				ZonedDateTime saoPaulo3 = ZonedDateTime.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("America/Sao_Paulo"));
				tokyo2 = tokyo2.plusHours(12);
		System.out.println(tokyo2.isEqual(saoPaulo3));

		System.out.println("-------------------------------------");
		
		System.out.println("hoje é dia: "+ MonthDay.now().getDayOfMonth());
		
		YearMonth ym = YearMonth.from(date);
		System.out.println(ym.getMonth() + " " + ym.getYear());
		
		
		System.out.println(LocalDate.of(2014, 12, 25));
		System.out.println(LocalDate.of(2014, Month.DECEMBER, 25));
		
		System.out.println("-------------------------------------");
		
		System.out.println(Month.DECEMBER.firstMonthOfQuarter());
		System.out.println(Month.DECEMBER.plus(2));
		System.out.println(Month.DECEMBER.minus(1));
		
		Locale pt = new Locale("pt");
		System.out.println(Month.DECEMBER
		.getDisplayName(TextStyle.FULL, pt));
		System.out.println(Month.DECEMBER
		.getDisplayName(TextStyle.SHORT, pt));
		
		
		
		LocalDateTime agora4 = LocalDateTime.now();
		String resultado = agora4.format(DateTimeFormatter.ISO_LOCAL_TIME);
		
		System.out.println(resultado);
		
		System.out.println("-------------------------------------");
		
		LocalDate agora5 = LocalDate.now();
		LocalDate outraData = LocalDate.of(1989, Month.JANUARY, 25);
		Period periodo = Period.between(outraData, agora5);
		System.out.printf("%s dias, %s meses e %s anos",
		periodo.getDays(), periodo.getMonths(), periodo.getYears());
		
		System.out.println("-------------------------------------");
			
		LocalDate agora6 = LocalDate.now();
		LocalDate outraData2 = LocalDate.of(2015, Month.JANUARY, 25);
		Period periodo2 = Period.between(outraData2, agora6);
		System.out.printf("%s dias, %s meses e %s anos",
		periodo2.getDays(), periodo2.getMonths(), periodo2.getYears());
		
		System.out.println("-------------------------------------");
		
		Period periodo3 = Period.between(outraData2, agora6);
		if (periodo3.isNegative()) {
			periodo3 = periodo3.negated();
		}
		System.out.printf("%s dias, %s meses e %s anos",
		periodo3.getDays(), periodo3.getMonths(), periodo3.getYears());
		
		System.out.println("-------------------------------------");
		
		LocalDateTime agora7 = LocalDateTime.now();
		LocalDateTime daquiAUmaHora = LocalDateTime.now().plusHours(1);
		Duration duration = Duration.between(agora, daquiAUmaHora);
		if (duration.isNegative()) {
		duration = duration.negated();
		}
		System.out.printf("%s horas, %s minutos e %s segundos",
		duration.toHours(), duration.toMinutes(), duration.getSeconds());
		
		System.out.println(agora7);
		System.out.println("-------------------------------------");
		
        System.out.println("Test");	
    
		
	}
}
