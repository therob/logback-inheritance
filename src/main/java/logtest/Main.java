package logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	public static void main(String[] args) {
		Impl impl = new Impl();
		impl.doILog();
		impl.doOLog();
		impl.doRLog();
		impl.doSLog();
	}

	public static class Base {
		protected Logger ilog = LoggerFactory.getLogger(getClass());
		protected Logger olog = LoggerFactory.getLogger(getClass());
		protected Logger rlog = LoggerFactory.getLogger(getClass());
		private static Logger SLOG = LoggerFactory.getLogger(Base.class);
		
		public void doILog() {
			ilog.info("getClass() - Base - instance Logger");
		}
		
		public void doOLog() {
			olog.info("getClass() - Base - overridden instance Logger");
		}
		
		public void doRLog() {
			rlog.info("getClass() - Base - reassigned instance Logger");
		}
		
		public void doSLog() {
			SLOG.info("Base.class - Base - static Logger");
		}
	}
	
	public static class Impl extends Base {
		protected Logger olog = LoggerFactory.getLogger(Base.class);
		private static Logger SLOG = LoggerFactory.getLogger(Impl.class);
		
		public Impl() {
			rlog = LoggerFactory.getLogger(Base.class);
		}
		
		public void doILog() {
			super.doILog();
			ilog.info("getClass() - Impl - instance Logger");
		}
		
		public void doOLog() {
			super.doOLog();
			olog.info("Base.class - Impl - overridden instance Logger");
		}
		
		public void doRLog() {
			super.doRLog();
			rlog.info("Base.class - Impl - reassigned instance Logger");
		}
		
		public void doSLog() {
			super.doSLog();
			SLOG.info("Impl.class - Impl - static Logger");
		}
	}
}
