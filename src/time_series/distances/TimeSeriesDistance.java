package time_series.distances;

import time_series.TimeSeries;

public interface TimeSeriesDistance {
    double distance(TimeSeries x, TimeSeries y);

}
