package org.sackfix.fix43

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX43.xml
  */
case class AllocationMessage(allocIDField:AllocIDField,
                             allocTransTypeField:AllocTransTypeField,
                             allocTypeField:AllocTypeField,
                             refAllocIDField:Option[RefAllocIDField]=None,
                             allocLinkIDField:Option[AllocLinkIDField]=None,
                             allocLinkTypeField:Option[AllocLinkTypeField]=None,
                             bookingRefIDField:Option[BookingRefIDField]=None,
                             noOrdersField:NoOrdersField,
                             ordersGroups: List[OrdersGroup],
                             noExecsField:Option[NoExecsField]=None,
                             execsGroups: Option[List[ExecsGroup]]=None,
                             sideField:SideField,
                             instrumentComponent:InstrumentComponent,
                             quantityField:QuantityField,
                             lastMktField:Option[LastMktField]=None,
                             tradeOriginationDateField:Option[TradeOriginationDateField]=None,
                             tradingSessionIDField:Option[TradingSessionIDField]=None,
                             tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                             priceTypeField:Option[PriceTypeField]=None,
                             avgPxField:AvgPxField,
                             currencyField:Option[CurrencyField]=None,
                             avgPrxPrecisionField:Option[AvgPrxPrecisionField]=None,
                             partiesComponent:Option[PartiesComponent]=None,
                             tradeDateField:TradeDateField,
                             transactTimeField:Option[TransactTimeField]=None,
                             settlmntTypField:Option[SettlmntTypField]=None,
                             futSettDateField:Option[FutSettDateField]=None,
                             grossTradeAmtField:Option[GrossTradeAmtField]=None,
                             concessionField:Option[ConcessionField]=None,
                             totalTakedownField:Option[TotalTakedownField]=None,
                             netMoneyField:Option[NetMoneyField]=None,
                             positionEffectField:Option[PositionEffectField]=None,
                             textField:Option[TextField]=None,
                             encodedTextLenField:Option[EncodedTextLenField]=None,
                             encodedTextField:Option[EncodedTextField]=None,
                             numDaysInterestField:Option[NumDaysInterestField]=None,
                             accruedInterestRateField:Option[AccruedInterestRateField]=None,
                             totalAccruedInterestAmtField:Option[TotalAccruedInterestAmtField]=None,
                             legalConfirmField:Option[LegalConfirmField]=None,
                             noAllocsField:NoAllocsField,
                             allocsGroups: List[AllocsGroup]) extends SfFixMessageBody("J")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noOrdersField.value != ordersGroups.size)
    throw SfRepeatingGroupCountException(NoOrdersField.TagId,noOrdersField.value, ordersGroups.size)
  if (noExecsField.map(_.value).getOrElse(0) != execsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoExecsField.TagId,noExecsField.map(_.value).getOrElse(0), execsGroups.map(_.size).getOrElse(0))
  if (noAllocsField.value != allocsGroups.size)
    throw SfRepeatingGroupCountException(NoAllocsField.TagId,noAllocsField.value, allocsGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,allocIDField)
    fmt(b,allocTransTypeField)
    fmt(b,allocTypeField)
    refAllocIDField.foreach(fmt(b,_))
    allocLinkIDField.foreach(fmt(b,_))
    allocLinkTypeField.foreach(fmt(b,_))
    bookingRefIDField.foreach(fmt(b,_))
    fmt(b,noOrdersField)
    noExecsField.foreach(fmt(b,_))
    execsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    fmt(b,sideField)
    fmt(b,instrumentComponent)
    fmt(b,quantityField)
    lastMktField.foreach(fmt(b,_))
    tradeOriginationDateField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    fmt(b,avgPxField)
    currencyField.foreach(fmt(b,_))
    avgPrxPrecisionField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    fmt(b,tradeDateField)
    transactTimeField.foreach(fmt(b,_))
    settlmntTypField.foreach(fmt(b,_))
    futSettDateField.foreach(fmt(b,_))
    grossTradeAmtField.foreach(fmt(b,_))
    concessionField.foreach(fmt(b,_))
    totalTakedownField.foreach(fmt(b,_))
    netMoneyField.foreach(fmt(b,_))
    positionEffectField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    numDaysInterestField.foreach(fmt(b,_))
    accruedInterestRateField.foreach(fmt(b,_))
    totalAccruedInterestAmtField.foreach(fmt(b,_))
    legalConfirmField.foreach(fmt(b,_))
    fmt(b,noAllocsField)
    b
  }

}
     
object AllocationMessage extends SfFixMessageDecoder {
  val MsgType="J"
  val MsgName="Allocation"
             
  override val MandatoryFields = HashSet[Int](
    AllocIDField.TagId, AllocTransTypeField.TagId, AllocTypeField.TagId, NoOrdersField.TagId, SideField.TagId, 
    QuantityField.TagId, AvgPxField.TagId, TradeDateField.TagId, NoAllocsField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    OrdersGroup.isMandatoryField(tagId) || ExecsGroup.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || PartiesComponent.isMandatoryField(tagId) || 
    AllocsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    RefAllocIDField.TagId, AllocLinkIDField.TagId, AllocLinkTypeField.TagId, BookingRefIDField.TagId, NoExecsField.TagId, 
    LastMktField.TagId, TradeOriginationDateField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, PriceTypeField.TagId, 
    CurrencyField.TagId, AvgPrxPrecisionField.TagId, TransactTimeField.TagId, SettlmntTypField.TagId, FutSettDateField.TagId, 
    GrossTradeAmtField.TagId, ConcessionField.TagId, TotalTakedownField.TagId, NetMoneyField.TagId, PositionEffectField.TagId, 
    TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, NumDaysInterestField.TagId, AccruedInterestRateField.TagId, 
    TotalAccruedInterestAmtField.TagId, LegalConfirmField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    OrdersGroup.isOptionalField(tagId) || ExecsGroup.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || PartiesComponent.isOptionalField(tagId) || 
    AllocsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    OrdersGroup.isFieldOf(tagId) || ExecsGroup.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || 
    PartiesComponent.isFieldOf(tagId) || AllocsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoOrdersField.TagId, NoExecsField.TagId, NoAllocsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==AllocIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(AllocationMessage(AllocIDField.decode(myFields.get(AllocIDField.TagId)).get,
        AllocTransTypeField.decode(myFields.get(AllocTransTypeField.TagId)).get,
        AllocTypeField.decode(myFields.get(AllocTypeField.TagId)).get,
        myFields.get(RefAllocIDField.TagId).flatMap(f=>RefAllocIDField.decode(f)),
        myFields.get(AllocLinkIDField.TagId).flatMap(f=>AllocLinkIDField.decode(f)),
        myFields.get(AllocLinkTypeField.TagId).flatMap(f=>AllocLinkTypeField.decode(f)),
        myFields.get(BookingRefIDField.TagId).flatMap(f=>BookingRefIDField.decode(f)),
        NoOrdersField.decode(myFields.get(NoOrdersField.TagId)).get,
        if (nextTagPosLookup.contains(NoOrdersField.TagId)) OrdersGroup.decode(flds, nextTagPosLookup(NoOrdersField.TagId)).get else List.empty,
        myFields.get(NoExecsField.TagId).flatMap(f=>NoExecsField.decode(f)),
        if (nextTagPosLookup.contains(NoExecsField.TagId)) ExecsGroup.decode(flds, nextTagPosLookup(NoExecsField.TagId)) else None,
        SideField.decode(myFields.get(SideField.TagId)).get,
        InstrumentComponent.decode(flds, startPos).get,
        QuantityField.decode(myFields.get(QuantityField.TagId)).get,
        myFields.get(LastMktField.TagId).flatMap(f=>LastMktField.decode(f)),
        myFields.get(TradeOriginationDateField.TagId).flatMap(f=>TradeOriginationDateField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        AvgPxField.decode(myFields.get(AvgPxField.TagId)).get,
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(AvgPrxPrecisionField.TagId).flatMap(f=>AvgPrxPrecisionField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        TradeDateField.decode(myFields.get(TradeDateField.TagId)).get,
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(SettlmntTypField.TagId).flatMap(f=>SettlmntTypField.decode(f)),
        myFields.get(FutSettDateField.TagId).flatMap(f=>FutSettDateField.decode(f)),
        myFields.get(GrossTradeAmtField.TagId).flatMap(f=>GrossTradeAmtField.decode(f)),
        myFields.get(ConcessionField.TagId).flatMap(f=>ConcessionField.decode(f)),
        myFields.get(TotalTakedownField.TagId).flatMap(f=>TotalTakedownField.decode(f)),
        myFields.get(NetMoneyField.TagId).flatMap(f=>NetMoneyField.decode(f)),
        myFields.get(PositionEffectField.TagId).flatMap(f=>PositionEffectField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(NumDaysInterestField.TagId).flatMap(f=>NumDaysInterestField.decode(f)),
        myFields.get(AccruedInterestRateField.TagId).flatMap(f=>AccruedInterestRateField.decode(f)),
        myFields.get(TotalAccruedInterestAmtField.TagId).flatMap(f=>TotalAccruedInterestAmtField.decode(f)),
        myFields.get(LegalConfirmField.TagId).flatMap(f=>LegalConfirmField.decode(f)),
        NoAllocsField.decode(myFields.get(NoAllocsField.TagId)).get,
        if (nextTagPosLookup.contains(NoAllocsField.TagId)) AllocsGroup.decode(flds, nextTagPosLookup(NoAllocsField.TagId)).get else List.empty))
    } else None
  }

    
}
     