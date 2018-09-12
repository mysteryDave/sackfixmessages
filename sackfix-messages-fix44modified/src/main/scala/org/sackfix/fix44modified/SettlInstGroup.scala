package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class SettlInstGroup(settlInstIDField:Option[SettlInstIDField]=None,
                          settlInstTransTypeField:Option[SettlInstTransTypeField]=None,
                          settlInstRefIDField:Option[SettlInstRefIDField]=None,
                          partiesComponent:Option[PartiesComponent]=None,
                          sideField:Option[SideField]=None,
                          productField:Option[ProductField]=None,
                          securityTypeField:Option[SecurityTypeField]=None,
                          cFICodeField:Option[CFICodeField]=None,
                          effectiveTimeField:Option[EffectiveTimeField]=None,
                          expireTimeField:Option[ExpireTimeField]=None,
                          lastUpdateTimeField:Option[LastUpdateTimeField]=None,
                          settlInstructionsDataComponent:Option[SettlInstructionsDataComponent]=None,
                          paymentMethodField:Option[PaymentMethodField]=None,
                          paymentRefField:Option[PaymentRefField]=None,
                          cardHolderNameField:Option[CardHolderNameField]=None,
                          cardNumberField:Option[CardNumberField]=None,
                          cardStartDateField:Option[CardStartDateField]=None,
                          cardExpDateField:Option[CardExpDateField]=None,
                          cardIssNumField:Option[CardIssNumField]=None,
                          paymentDateField:Option[PaymentDateField]=None,
                          paymentRemitterIDField:Option[PaymentRemitterIDField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    settlInstIDField.foreach(fmt(b,_))
    settlInstTransTypeField.foreach(fmt(b,_))
    settlInstRefIDField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    productField.foreach(fmt(b,_))
    securityTypeField.foreach(fmt(b,_))
    cFICodeField.foreach(fmt(b,_))
    effectiveTimeField.foreach(fmt(b,_))
    expireTimeField.foreach(fmt(b,_))
    lastUpdateTimeField.foreach(fmt(b,_))
    settlInstructionsDataComponent.foreach(fmt(b,_))
    paymentMethodField.foreach(fmt(b,_))
    paymentRefField.foreach(fmt(b,_))
    cardHolderNameField.foreach(fmt(b,_))
    cardNumberField.foreach(fmt(b,_))
    cardStartDateField.foreach(fmt(b,_))
    cardExpDateField.foreach(fmt(b,_))
    cardIssNumField.foreach(fmt(b,_))
    paymentDateField.foreach(fmt(b,_))
    paymentRemitterIDField.foreach(fmt(b,_))
    b
  }

}
     
object SettlInstGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || SettlInstructionsDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SettlInstIDField.TagId, SettlInstTransTypeField.TagId, SettlInstRefIDField.TagId, SideField.TagId, ProductField.TagId, 
    SecurityTypeField.TagId, CFICodeField.TagId, EffectiveTimeField.TagId, ExpireTimeField.TagId, LastUpdateTimeField.TagId, 
    PaymentMethodField.TagId, PaymentRefField.TagId, CardHolderNameField.TagId, CardNumberField.TagId, CardStartDateField.TagId, 
    CardExpDateField.TagId, CardIssNumField.TagId, PaymentDateField.TagId, PaymentRemitterIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || SettlInstructionsDataComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || SettlInstructionsDataComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SettlInstIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[SettlInstGroup]=ArrayBuffer.empty[SettlInstGroup]):Option[List[SettlInstGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[SettlInstGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[SettlInstGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(SettlInstGroup(myFields.get(SettlInstIDField.TagId).flatMap(f=>SettlInstIDField.decode(f)),
          myFields.get(SettlInstTransTypeField.TagId).flatMap(f=>SettlInstTransTypeField.decode(f)),
          myFields.get(SettlInstRefIDField.TagId).flatMap(f=>SettlInstRefIDField.decode(f)),
          PartiesComponent.decode(flds, startPos),
          myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
          myFields.get(ProductField.TagId).flatMap(f=>ProductField.decode(f)),
          myFields.get(SecurityTypeField.TagId).flatMap(f=>SecurityTypeField.decode(f)),
          myFields.get(CFICodeField.TagId).flatMap(f=>CFICodeField.decode(f)),
          myFields.get(EffectiveTimeField.TagId).flatMap(f=>EffectiveTimeField.decode(f)),
          myFields.get(ExpireTimeField.TagId).flatMap(f=>ExpireTimeField.decode(f)),
          myFields.get(LastUpdateTimeField.TagId).flatMap(f=>LastUpdateTimeField.decode(f)),
          SettlInstructionsDataComponent.decode(flds, startPos),
          myFields.get(PaymentMethodField.TagId).flatMap(f=>PaymentMethodField.decode(f)),
          myFields.get(PaymentRefField.TagId).flatMap(f=>PaymentRefField.decode(f)),
          myFields.get(CardHolderNameField.TagId).flatMap(f=>CardHolderNameField.decode(f)),
          myFields.get(CardNumberField.TagId).flatMap(f=>CardNumberField.decode(f)),
          myFields.get(CardStartDateField.TagId).flatMap(f=>CardStartDateField.decode(f)),
          myFields.get(CardExpDateField.TagId).flatMap(f=>CardExpDateField.decode(f)),
          myFields.get(CardIssNumField.TagId).flatMap(f=>CardIssNumField.decode(f)),
          myFields.get(PaymentDateField.TagId).flatMap(f=>PaymentDateField.decode(f)),
          myFields.get(PaymentRemitterIDField.TagId).flatMap(f=>PaymentRemitterIDField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     